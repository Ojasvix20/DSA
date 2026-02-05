
// detect cycle in an undirected graph using BFS

import java.util.*;
public class DetectCycleDFS{
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
        boolean hasCycle = false;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(dfs(i,-1,adj, vis)){
                    hasCycle= true;
                    break;
                }
            } 
        }
        System.out.Println(hasCycle);
    }
    public static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] vis ){
        vis[node]= true;
        for(int nbr: adj.get(node)){
            if(!vis[nbr]){
                if(dfs(nbr, node, adj, vis)) return true;
            }
            else if(nbr!=parent)
            return true;
        }
        return false;
    }
}
