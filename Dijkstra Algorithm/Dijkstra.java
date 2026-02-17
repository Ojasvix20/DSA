//SHORTEST ROUTE -1 CSES
import java.io.*;
import java.util.*;

class Pair {
    int node;
    long dist;
    Pair(int n, long dist) {
        this.node = n;
        this.dist = dist;
    }
}

public class Dijkstra {

    public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            // int src = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());

                adj.get(u).add(new Pair(v, w));
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

            long[] distance = new long[n + 1];
            Arrays.fill(distance, Long.MAX_VALUE);
            distance[1] = 0;

            pq.offer(new Pair(1, 0));

            while (!pq.isEmpty()) {
                Pair top = pq.poll();
                long d = top.dist;
                int u = top.node;

                if (d > distance[u]) continue;

                for (Pair nbr : adj.get(u)) {
                    int v = nbr.node;
                    long newD = d + nbr.dist;

                    if (distance[v] > newD) {
                        distance[v] = newD;
                        pq.offer(new Pair(v, newD));
                    }
                }
            }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
        sb.append(distance[i]).append(" ");
        System.out.println(sb);
    }
}
