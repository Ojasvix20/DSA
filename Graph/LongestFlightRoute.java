// cses - longest flight route
import java.io.*;
import java.util.*;

public class LongestFlightRoute {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        int[] indeg = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);   
            indeg[v]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int[] dp = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        dp[1] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();

            // Skip unreachable nodes
            if (dp[u] == 0) {
                for (int nbr : adj[u]) {   
                    if (--indeg[nbr] == 0) q.offer(nbr);
                }
                continue;
            }

            for (int nbr : adj[u]) {   
                if (dp[u] + 1 > dp[nbr]) {
                    dp[nbr] = dp[u] + 1;
                    parent[nbr] = u;
                }
                if (--indeg[nbr] == 0) q.offer(nbr);
            }
        }

        if (dp[n] == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> path = new ArrayList<>();
        int cur = n;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int x : path) System.out.print(x + " ");
    }
}
