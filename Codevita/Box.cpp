#include <bits/stdc++.h>
using namespace std;

/*
Problem:
We’re given a 3×3 (or N×N) cube with 6 faces.
Each face has N×N colored cells.
We’re also given K rotation instructions like:
  front 1 up
  back 2 down
Each instruction means rotate that face’s layer once
in the specified direction. After each rotation,
if any cube face becomes uniform (all same color),
we print that instruction and stop.
If none do, we print "No".
*/

// --- Cube faces order mapping ---
// 0: front
// 1: back
// 2: left
// 3: right
// 4: up
// 5: down

struct Cube {
    int N;
    vector<vector<vector<char>>> f;
    Cube(int n=3) {
        N = n;
        f.assign(6, vector<vector<char>>(N, vector<char>(N, ' ')));
    }
};

// rotate a single face clockwise
void rotateFaceCW(vector<vector<char>> &face) {
    int n = face.size();
    vector<vector<char>> tmp(n, vector<char>(n));
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            tmp[j][n-1-i] = face[i][j];
    face = tmp;
}
// rotate a single face counterclockwise
void rotateFaceCCW(vector<vector<char>> &face) {
    int n = face.size();
    vector<vector<char>> tmp(n, vector<char>(n));
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            tmp[n-1-j][i] = face[i][j];
    face = tmp;
}

bool isUniform(const Cube &c){
    for(int f=0;f<6;f++){
        char col = c.f[f][0][0];
        bool ok=true;
        for(int i=0;i<c.N;i++)
            for(int j=0;j<c.N;j++)
                if(c.f[f][i][j]!=col) ok=false;
        if(ok) return true;
    }
    return false;
}

// utility to rotate a ring between faces
void rotateLayer(Cube &c,string face,int layer,string dir){
    int N=c.N;
    layer--; // make 0-indexed
    if(face=="front"){
        if(dir=="up"){
            // rotate front face CW
            rotateFaceCW(c.f[0]);
        } else if(dir=="down"){
            rotateFaceCCW(c.f[0]);
        }
    }
    else if(face=="back"){
        if(dir=="up"){
            rotateFaceCCW(c.f[1]);
        } else if(dir=="down"){
            rotateFaceCW(c.f[1]);
        }
    }
    else if(face=="left"){
        if(dir=="up"){
            rotateFaceCW(c.f[2]);
        } else rotateFaceCCW(c.f[2]);
    }
    else if(face=="right"){
        if(dir=="up"){
            rotateFaceCW(c.f[3]);
        } else rotateFaceCCW(c.f[3]);
    }
    else if(face=="up"){
        if(dir=="right"){
            rotateFaceCW(c.f[4]);
        } else rotateFaceCCW(c.f[4]);
    }
    else if(face=="down"){
        if(dir=="right"){
            rotateFaceCW(c.f[5]);
        } else rotateFaceCCW(c.f[5]);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N,K;
    if(!(cin>>N>>K)) return 0;
    Cube cube(N);

    // read 6 faces * N rows
    for(int f=0;f<6;f++){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cin>>cube.f[f][i][j];
            }
        }
    }

    vector<string> face(K),dir(K);
    vector<int> layer(K);
    for(int i=0;i<K;i++){
        cin>>face[i]>>layer[i]>>dir[i];
    }

    for(int i=0;i<K;i++){
        rotateLayer(cube,face[i],layer[i],dir[i]);
        if(isUniform(cube)){
            cout<<face[i]<<" "<<layer[i]<<" "<<dir[i]<<"\n";
            return 0;
        }
    }
    cout<<"No\n";
    return 0;
}
