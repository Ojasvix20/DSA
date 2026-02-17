import java.util.*;
//cf- 1829E
public class TheLakes{
	static int n; 
	static int m;


	public static int dfs(int i, int j, int[][] grid, boolean[][] visited){
		if(i<0 || j <0 || i>=n || j>=m || visited[i][j] || grid[i][j]==0){
			return 0;
		}
		visited[i][j]=true;
        int sum = grid[i][j];
		sum+=dfs(i+1,j, grid, visited);
		sum+=dfs(i-1,j, grid, visited);
		sum+=dfs(i,j-1, grid, visited);
		sum+=dfs(i,j+1, grid, visited);

		return sum;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();


		while(t-->0){
			n= sc.nextInt();
			m= sc.nextInt();

			boolean[][] visited = new boolean[n][m];
			int[][] grid = new int[n][m];
			for(int i=0; i<n;i++){
				for(int j=0; j<m;j++){
					grid[i][j]= sc.nextInt();
				}
			}
            int maxVol=0;
			
            for(int i=0; i<n;i++){
			    for(int j=0; j<m; j++){
				    if(grid[i][j]>0 && !visited[i][j]){
				    		int vol= dfs(i,j, grid, visited);	
                            maxVol = Math.max(vol, maxVol);
                    }
                }
		    }   

			System.out.println(maxVol);
		}
		
	}
	
}

//BFS APPROACH
import java.util.*;

public class TheLakes {
    static int n, m;

    public static int bfs(int i, int j, int[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        int sum = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            sum += grid[x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                        !visited[nx][ny] && grid[nx][ny] > 0) {

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            n = sc.nextInt();
            m = sc.nextInt();

            int[][] grid = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    grid[i][j] = sc.nextInt();

            int maxVol = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (grid[i][j] > 0 && !visited[i][j]) {
                        int vol = bfs(i, j, grid, visited);
                        maxVol = Math.max(maxVol, vol);
                    }
                }
            }

            System.out.println(maxVol);
        }
    }
}
