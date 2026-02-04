import java.util.*;
public class AdjMatrix{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] adj = new int[n+1][n+1];
		for(int i=0; i<m; i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
            if (u >= 1 && u <= n && v >= 1 && v <= n) {
                adj[u][v] = 1;
                adj[v][u] = 1;   
            } else {
                System.out.println("Invalid edge: " + u + " " + v);
            }
		}
        for(int i=0; i<=n; i++){
            System.out.println(Arrays.toString(adj[i]));
        }

	}	
}