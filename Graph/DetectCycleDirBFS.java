import java.util.*;
//detect cycle in directed graph using bfs
public class DetectCycleDirBFS{
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

        if(isCycle(V, adj)){
            System.out.println("YES");
        }else{
            System.out.println("NO");

        }
    }

    public static boolean isCyclic(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        // calculate indegree
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // add all nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        // BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int nbr : adj.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        // if not all nodes processed => cycle
        return count != V;
    }
}

