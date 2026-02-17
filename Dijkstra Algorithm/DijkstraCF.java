//DIJKSTRA CF.20c
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

public class DijkstraCF {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

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
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        int[] parent =new int[n+1];
        Arrays.fill(parent, -1);
        parent[1]=1;

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
                    parent[v]=u;
                    pq.offer(new Pair(v, newD));
                }
            }
        }
        if (distance[n] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        
        List<Integer> path = new ArrayList<>();
        int curr =n;
        while(curr!=-1){
            path.add(curr);
            curr=parent[curr];
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int x : path) sb.append(x).append(" ");
        System.out.println(sb);
    }
}
