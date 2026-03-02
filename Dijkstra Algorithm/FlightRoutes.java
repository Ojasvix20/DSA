// flight routes - cses
import java.util.*;
import java.io.*;
class Pair {
    int node;
    long dist;
    Pair(int n, long dist) {
        this.node = n;
        this.dist = dist;
    }
}

public class FlightRoutes{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //citites
        int m = Integer.parseInt(st.nextToken());   // flights
        int k = Integer.parseInt(st.nextToken());   // no of solution needed
        List<List<Pair>> adj =new ArrayList<>();
        int t=0;
        while(t++<=n){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i <m ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj.get(a).add(new Pair(b,c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(1,0));
        List<List<Long>> dist = new ArrayList<>();
        t=0;
        while(t++<=n){
            dist.add(new ArrayList<>());
        }
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            long d= curr.dist;
            int node = curr.node;
            if (dist.get(node).size() >= k) continue;
            dist.get(node).add(d);
            for (Pair nxt : adj.get(node)) {

                if (dist.get(nxt.node).size() < k) {
                    pq.add(new Pair(nxt.node, d + nxt.dist));
                }
            }
        }
        
        StringBuilder sb= new StringBuilder();
        for(long x: dist.get( n)){
            sb.append(x);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}