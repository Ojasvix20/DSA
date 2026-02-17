// CSES Hamiltonian Flights
// https://cses.fi/problemset/task/1690

import java.util.*;
class HamiltonionFlights{
    static int ans;
    static int totalCities;
    static int n;
    static int m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        totalCities=n;

        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n+1];

        for(int i=0; i<m; i++){
            int u= sc.nextInt();            
            int v= sc.nextInt();            
            adj.get(u).add(v);
        }
        ans=0;
        vis[1]=true;
        dfs(1,1, adj, vis);

        System.out.println(ans);

    }
    public static void dfs(int node, int countVisited, List<List<Integer>> adj, boolean[] vis){
        if (node == n) {
            if (countVisited == totalCities) ans++;
            return;
        }   

        for(int nbr: adj.get(node)){
            if(!vis[nbr]){
                vis[nbr]=true;
                dfs(nbr, countVisited + 1, adj, vis);
                vis[nbr] = false; // backtrack
            }
        }
    }
}