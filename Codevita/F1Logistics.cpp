#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

// Struct to hold race information
struct Race {
    int x, y, day;
};

// Custom comparator to sort races by day
bool compareRaces(const Race& a, const Race& b) {
    return a.day < b.day;
}

// Helper function to calculate Manhattan distance
int manhattanDist(const Race& a, const Race& b) {
    return abs(a.x - b.x) + abs(a.y - b.y);
}

// DFS function to find an augmenting path for matching
// u: current node on the left side
// adj: adjacency list of the bipartite graph
// vis: visited array for the current DFS
// match: match[v] stores the left-side node matched with right-side node v
bool dfs(int u, const vector<vector<int>>& adj, vector<bool>& vis, vector<int>& match) {
    // Mark the left-side node as visited
    vis[u] = true;

    // Iterate through all neighbors 'v' on the right side
    for (int v : adj[u]) {
        // 'v_match' is the left-side node currently matched with 'v'
        int v_match = match[v];

        // If 'v' is unmatched (v_match == -1)
        // OR if we can find a new path for 'v_match'
        if (v_match == -1 || (!vis[v_match] && dfs(v_match, adj, vis, match))) {
            // We found an augmenting path.
            // Match 'u' with 'v'.
            match[v] = u;
            return true;
        }
    }
    // No augmenting path found from 'u'
    return false;
}

int main() {
    // Optimize C++ I/O
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    if (N == 0) {
        cout << 0 << "\n";
        return 0;
    }

    vector<Race> races(N);
    for (int i = 0; i < N; ++i) {
        cin >> races[i].x >> races[i].y >> races[i].day;
    }

    // --- Step 1: Sort races by day ---
    sort(races.begin(), races.end(), compareRaces);

    // --- Step 2: Build the bipartite graph ---
    // adj[i] will store all 'j's that race 'i' can travel to
    vector<vector<int>> adj(N);
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (i == j) continue;

            int time_diff = races[j].day - races[i].day;
            
            // We only care about forward-in-time travel
            if (time_diff > 0) {
                int dist = manhattanDist(races[i], races[j]);
                if (time_diff >= dist) {
                    // A car can go from i to j. Add bipartite edge.
                    adj[i].push_back(j);
                }
            }
        }
    }

    // --- Step 3: Find Maximum Bipartite Matching ---
    int max_matches = 0;
    vector<int> match(N, -1); // match[j] = i (right node j is matched with left node i)
    
    // For each node 'i' on the left...
    for (int i = 0; i < N; ++i) {
        // ...try to find an augmenting path
        vector<bool> vis(N, false); // Reset visited array for each new DFS
        if (dfs(i, adj, vis, match)) {
            max_matches++;
        }
    }

    // --- Step 4: Output the result ---
    // Min Path Cover = N - Max Matching
    cout << (N - max_matches) << "\n";

    return 0;
}