#include <bits/stdc++.h>
using namespace std;

struct Pt {
    int x, y;
    bool operator<(const Pt& o) const { return x!=o.x ? x<o.x : y<o.y; }
    bool operator==(const Pt& o) const { return x==o.x && y==o.y; }
    Pt operator+(const Pt& o) const { return {x+o.x, y+o.y}; }
    Pt operator-(const Pt& o) const { return {x-o.x, y-o.y}; }
};

struct Seg { Pt p1, p2; };

int sgn(int v){ return (v>0)-(v<0); }
int cheb(const Pt &a,const Pt &b){ return max(abs(a.x-b.x), abs(a.y-b.y)); }
Pt rotate90(const Pt &v){ return {v.y, -v.x}; }

vector<Pt> get_rotations(const Pt &v){
    vector<Pt> r(4);
    r[0]=v;
    for(int i=1;i<4;i++) r[i]=rotate90(r[i-1]);
    return r;
}

bool onSegment(Pt p, Pt a, Pt b){
    return p.x>=min(a.x,b.x) && p.x<=max(a.x,b.x) &&
           p.y>=min(a.y,b.y) && p.y<=max(a.y,b.y) &&
           1LL*(b.y-a.y)*(p.x-a.x)==1LL*(p.y-a.y)*(b.x-a.x);
}

int orientation(Pt p, Pt q, Pt r){
    long long val = 1LL*(q.y-p.y)*(r.x-q.x) - 1LL*(q.x-p.x)*(r.y-q.y);
    if(val==0) return 0;
    return (val>0)?1:2;
}

bool intersect(const Seg &s1, const Seg &s2){
    Pt p1=s1.p1, q1=s1.p2, p2=s2.p1, q2=s2.p2;
    int o1=orientation(p1,q1,p2);
    int o2=orientation(p1,q1,q2);
    int o3=orientation(p2,q2,p1);
    int o4=orientation(p2,q2,q1);
    if(o1!=o2 && o3!=o4) return true;
    if(o1==0 && onSegment(p2,p1,q1)) return true;
    if(o2==0 && onSegment(q2,p1,q1)) return true;
    if(o3==0 && onSegment(p1,p2,q2)) return true;
    if(o4==0 && onSegment(q1,p2,q2)) return true;
    return false;
}

// lattice points on segment via gcd stepping
vector<Pt> getPointsOnSegment(const Seg &s){
    vector<Pt> res;
    int dx = s.p2.x - s.p1.x;
    int dy = s.p2.y - s.p1.y;
    int g = std::gcd(abs(dx), abs(dy));
    int sx = (g==0?0:dx/g);
    int sy = (g==0?0:dy/g);
    Pt cur = s.p1;
    for(int i=0;i<=g;i++){
        res.push_back(cur);
        cur.x += sx; cur.y += sy;
    }
    return res;
}

struct Star {
    Pt center;
    // store unique directions (unit step) -> farthest vector in that direction
    vector<Pt> arms; // final arm vectors
    vector<vector<Pt>> arm_rotations; // cached rotations per arm
};

bool isPointOnStar(const Pt &p, const Star &s){
    for(const auto &armset : s.arm_rotations){
        for(const Pt &v : armset){
            Seg seg = {s.center, {s.center.x + v.x, s.center.y + v.y}};
            if(onSegment(p, seg.p1, seg.p2)) return true;
        }
    }
    return false;
}

bool doStarsConnect(const Star &a, const Star &b){
    for(const auto &armA : a.arm_rotations){
        for(const Pt &vA : armA){
            Seg segA = {a.center, {a.center.x + vA.x, a.center.y + vA.y}};
            for(const auto &armB : b.arm_rotations){
                for(const Pt &vB : armB){
                    Seg segB = {b.center, {b.center.x + vB.x, b.center.y + vB.y}};
                    if(intersect(segA, segB)) return true;
                }
            }
        }
    }
    return false;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    if(!(cin>>N)) return 0;
    vector<Seg> segs(N);
    for(int i=0;i<N;i++) cin>>segs[i].p1.x>>segs[i].p1.y>>segs[i].p2.x>>segs[i].p2.y;
    Pt src, dst;
    cin>>src.x>>src.y>>dst.x>>dst.y;

    // map lattice point -> set of segment indices that pass through it
    map<Pt, set<int>> pass;
    for(int i=0;i<N;i++){
        for(const Pt &p : getPointsOnSegment(segs[i])){
            pass[p].insert(i);
        }
    }

    vector<Star> stars;
    map<Pt,int> center_idx;

    for(const auto &kv : pass){
        const Pt &p = kv.first;
        const set<int> &indices = kv.second;
        if(indices.size() < 2) continue; // not an intersection
        // For this center, we want to collect farthest vector per unit direction
        // unit direction is (sgn(dx), sgn(dy)) -> one of 8 directions
        map<pair<int,int>, Pt> best; // dir -> vector (farthest)
        for(int idx : indices){
            // segment endpoints; both endpoints can form arms
            Pt e1 = segs[idx].p1;
            Pt e2 = segs[idx].p2;
            vector<Pt> cand = {e1, e2};
            for(const Pt &endp : cand){
                Pt v = {endp.x - p.x, endp.y - p.y};
                if(v.x==0 && v.y==0) continue;
                int dx = sgn(v.x);
                int dy = sgn(v.y);
                pair<int,int> dir = {dx, dy};
                // we want farthest in Chebyshev along this dir (i.e., maximize max(|vx|,|vy|) with sign)
                int distNew = max(abs(v.x), abs(v.y));
                if(best.find(dir) == best.end()){
                    best[dir] = v;
                } else {
                    Pt cur = best[dir];
                    int distCur = max(abs(cur.x), abs(cur.y));
                    if(distNew > distCur) best[dir] = v;
                }
            }
        }
        // create star
        Star s;
        s.center = p;
        for(auto &it : best){
            s.arms.push_back(it.second);
        }
        if(s.arms.empty()) continue;
        // cache rotations (for each arm, store 4 rotated vectors)
        for(const Pt &armv : s.arms){
            s.arm_rotations.push_back(get_rotations(armv));
        }
        center_idx[p] = (int)stars.size();
        stars.push_back(s);
    }

    int S = (int)stars.size();
    if(S == 0){
        cout << cheb(src, dst) << "\n";
        return 0;
    }

    // Build adjacency
    vector<vector<int>> adj(S);
    for(int i=0;i<S;i++){
        for(int j=i+1;j<S;j++){
            if(doStarsConnect(stars[i], stars[j])){
                adj[i].push_back(j);
                adj[j].push_back(i);
            }
        }
    }

    // collect stars containing source and destination
    vector<int> startNodes, targetNodes;
    for(int i=0;i<S;i++){
        if(isPointOnStar(src, stars[i])) startNodes.push_back(i);
        if(isPointOnStar(dst, stars[i])) targetNodes.push_back(i);
    }

    // If source and destination on same star
    for(int si : startNodes){
        for(int ti : targetNodes){
            if(si == ti){
                cout << 1 << "\n";
                return 0;
            }
        }
    }

    // BFS from startNodes
    vector<int> dist(S, -1);
    queue<pair<int,int>> q;
    for(int si : startNodes){
        dist[si] = 1;
        q.push({si,1});
    }

    while(!q.empty()){
        auto [u,d] = q.front(); q.pop();
        for(int v : adj[u]){
            if(dist[v] == -1){
                dist[v] = d + 1;
                q.push({v, d+1});
            }
        }
    }

    int ans = INT_MAX;
    for(int ti : targetNodes){
        if(dist[ti] != -1) ans = min(ans, dist[ti]);
    }
    if(ans != INT_MAX){
        cout << ans << "\n";
        return 0;
    }

    // unreachable by stars: compute minimal Chebyshev shift of destination to any reachable point on stars
    // Problem statement implies we can shift destination; they count endpoints and centers as candidate points
    int minShift = INT_MAX;
    for(const Star &s : stars){
        for(const auto &armset : s.arm_rotations){
            for(const Pt &v : armset){
                Pt endpoint = {s.center.x + v.x, s.center.y + v.y};
                minShift = min(minShift, cheb(dst, endpoint));
            }
        }
        minShift = min(minShift, cheb(dst, s.center));
    }
    cout << minShift << "\n";
    return 0;
}
