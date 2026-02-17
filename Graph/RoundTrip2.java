// Round TRIP II from CSES

import java.util.*;
public class RoundTrip2{

    static List<List<Integer>> adj;
    static boolean[] visited;
    static boolean[] pathVis;
    static int[] parent;
    static int start = -1, end = -1; 

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        visited = new boolean[n];
        path = new boolean[n];
        parent = new boolean[n];

         for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i)) break;
            }
        }

        if (start == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> cycle = new ArrayList<>();
            cycle.add(start);

            for (int v = end; v != start; v = parent[v]) {
                cycle.add(v);
            }
            cycle.add(start);

            Collections.reverse(cycle);

            System.out.println(cycle.size());
            for (int node : cycle)
                System.out.print((node + 1) + " ");
        }
    }

    public static void dfs(int node){
        visited[node]=true;
        path[node]=true;

        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                parent[nbr] = node;
                if (dfs(nbr)) return true;
            } else if (pathVis[nbr]) {
                start = nbr;
                end = node;
                return true;
            }
        }
         pathVis[node] = false;
        return false;
    }
}