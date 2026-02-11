import java.util.*;

public class DetectCycleDirDFS{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int V= sc.nextInt();
        int m= sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u= sc.nextInt();
            int v= sc.nextInt();
            adj.get(u).add(v);
        }
        
        System.out.println(isCyclic(adj) ? "true" : "false");
    }

    public static boolean isCyclic( List<List<Integer>> adj){
        int V= adj.size();
        boolean[] vis = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i] && isCyclicUtil(adj, i, vis, recStack)){
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(List<List<Integer>> adj, int u, boolean[] vis, boolean[] recStack){
        if (recStack[u]) return true;

        if (vis[u]) return false;

        vis[u] = true;
        recStack[u] = true;

        for (int v : adj.get(u)) {
            if (isCyclicUtil(adj, v, vis, recStack))
                return true;
        }

        recStack[u] = false;
        return false;

    }
}