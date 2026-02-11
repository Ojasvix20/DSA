import java.util.*;
// topological sort using dfs
class TopologicalSort {
    
    private static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                dfs(nbr, vis, st, adj);
            }
        }

        // push     
        st.push(node);
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, st, adj);
            }
        }

        int[] topo = new int[V];
        int idx = 0;

        while (!st.isEmpty()) {
            topo[idx++] = st.pop();
        }

        return topo;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // add edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(3).add(2);
        adj.get(3).add(4);              
        int[] ans= topoSort(V, adj);
        System.out.println(Arrays.toString(ans));

    }
}
