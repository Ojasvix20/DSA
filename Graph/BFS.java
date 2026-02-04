import java.util.*;

public class BFS{
	public static void main(String args[]){
		List<List<Integer>> adj= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m= sc.nextInt();
        int source = sc.nextInt();

		for(int i=0; i<=n; i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0; i<m;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		List<Integer> ans = bfs(n,source, adj);
		System.out.println(ans);

	}

	public static List<Integer> bfs (int n, int source, List<List<Integer>> adj){

		List<Integer> bfs = new ArrayList<>();
		boolean[] vis = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		vis[source]=true;
		while(!q.isEmpty()){
			Integer node = q.poll();
			bfs.add(node);
			for(Integer it: adj.get(node)){
				if(vis[it]==false){
					vis[it] =true;
					q.add(it);
				}
			}
		}
		return bfs;		

	}
}