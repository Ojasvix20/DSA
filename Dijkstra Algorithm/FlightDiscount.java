import java.util.*;
import java.io.*;

class Pair {
    long dist;
    int node;
    int status;
    Pair(long dist,int n, int status) {
        this.node = n;
        this.dist = dist;
        this.status = status;
    }
}
class Edge{
    long dist;
    int node;
    Edge(int n, long dist) {
        this.node = n;
        this.dist = dist;
    }
}

public class FlightDiscount{
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //citites
        int m = Integer.parseInt(st.nextToken());   // flights
        

        long[][] distance = new long[n + 1][2];
        // distance[i][0] -> discount not taken yet
        // distance[i][1] -> discount taken already
        for (long[] row : distance) Arrays.fill(row, Long.MAX_VALUE);


        List<List<Edge>> adj =new ArrayList<>();
        int t=0;
        while(t++<=n){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i <m ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj.get(a).add(new Edge(b,c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0,1,0));
        distance[1][0]=0;
                
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            long d = curr.dist;
            int u = curr.node;
            int status = curr.status;

            if(d> distance[u][status]) continue;

            for(Edge nxt: adj.get(u)){
                int v = nxt.node;
                long cost= nxt.dist;

                //case1: coupon not used yet (status==0)
                if(status==0){
                    //go ahead without coupon
                    if(distance[v][0]> d + cost){
                        distance[v][0] = d+cost;
                        pq.offer(new Pair(distance[v][0],v,0));
                    }
                
                    // use the coupon now:
                    if(distance[v][1]> d+cost/2){
                        distance[v][1]= d+cost/2;
                        pq.offer(new Pair(distance[v][1],v,1));
                    }
                }
                //Case2: coupon already used:
                else{
                    
                    // only normal traversal possible:
                    if(distance[v][1]> d + cost){
                        distance[v][1] = d+ cost;
                        pq.offer(new Pair(distance[v][1],v,1));
                    }
                }
              
            }
        }
        
        System.out.println(Math.min(distance[n][0], distance[n][1])); 
    }
}