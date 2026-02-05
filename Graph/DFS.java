import java.util.*;
public class DFS{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean[] vis = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<m; i++){
            int u= sc.nextInt();
            int v= sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0; i<n; i++){
            if(!vis[i]) dfs(i,adj, vis);
        }

        
    
    }
    public static void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node]= true;
        System.out.print(node + " ");
        for(int nbr: adj.get(node)){
            if(!vis[nbr]){
                dfs(nbr,adj, vis);
            }
        }
    }
}