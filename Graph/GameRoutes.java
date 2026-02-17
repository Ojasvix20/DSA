//cses- game orutes
// import java.io.*;
// import java.util.*;

// public class GameRoutes {
//     public static void main(String[] args) throws Exception {

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             adj.get(u).add(v);
//         }

//         int count = 0;

//         Queue<Integer> q = new LinkedList<>();
//         q.offer(1);

//         while (!q.isEmpty()) {
//             int node = q.poll();

//             for (int nbr : adj.get(node)) {
//                 if (nbr == n) {
//                     count++;
//                 }
//                 q.offer(nbr); // same logic as yours
//             }
//         }

//         System.out.println(count);
//     }
// }

//above code will give TLE
//use DP and indegree array for solution


import java.io.*;
import java.util.*;

public class GameRoutes {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        int[] indeg = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            indeg[v]++;
        }

        // Topological Sort (Kahn) algo
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                dp[v] = (dp[v] + dp[u]) % MOD;
                if (--indeg[v] == 0) q.offer(v);
            }
        }

        System.out.println(dp[n]);
    }
}
