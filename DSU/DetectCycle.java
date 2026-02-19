class DetectCycle {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int n=V;
        int m= edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for (int i = 0; i <=n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            
            if (find(u, parent) == find(v, parent)) {
                return true;
            }

            union(u, v, parent, rank);
        }

        return false;
    }
    static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent); // path compression
    }

    static void union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);

        if (px == py) return;

        if (rank[px] > rank[py]) parent[py] = px;
        else if (rank[py] > rank[px]) parent[px] = py;
        else {
            parent[px] = py;
            rank[py]++;
        }
    }
}