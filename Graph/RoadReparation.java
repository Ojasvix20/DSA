import java.io.*;
import java.util.*;

class RoadReparation {

    static int[] parent, size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] edges = new long[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Long.parseLong(st.nextToken());
            edges[i][1] = Long.parseLong(st.nextToken());
            edges[i][2] = Long.parseLong(st.nextToken());
        }
        // sort these edges by wieght
        Arrays.sort(edges, (a, b) -> Long.compare(a[2], b[2]));

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
        long ans = 0;
        int used = 0;

        for (int i = 0; i < m; i++) {
            int u = (int) edges[i][0];
            int v = (int) edges[i][1];
            long w = edges[i][2];

            int pu = find(u);
            int pv = find(v);
            if (pu != pv) {
                union(pu, pv);
                ans += w;
                used++;
            }

        }
        if (used == n - 1)
            System.out.println(ans);
        else
            System.out.println("IMPOSSIBLE");

    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public static void union(int u, int v) {
        if (size[u] > size[v]) {
            parent[v] = u;
            size[u]+= size[v];
        } else {
            parent[u] = v;
            size[v]+= size[u];
        }
    }
}