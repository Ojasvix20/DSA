import java.util.*;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}

public class LabyrinthCSES{
    static boolean isPath; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int Sx=-1;
        int Sy=-1;
        int Ex=-1;
        int Ey=-1;

        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            String row = sc.next();
            for(int j=0; j<m; j++){

                for (int k = 0; k < m; k++) {
                    grid[i][j] = row.charAt(j);
                }
                
                if(grid[i][j]=='A'){
                    Sx=i;
                    Sy=j;
                }
                if(grid[i][j]=='B'){
                    Ex=i;
                    Ey=j;
                }
            }
        }
        Pair[][] parent = new Pair[n][m];
        isPath= false;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        bfs(Sx, Sy, Ex, Ey, n, m, q, grid, vis, parent);

        if(isPath){
            System.out.println("YES");
        }else{
            System.out.println("NO");
            return;
        }
    }

    private static void bfs(int Sx, int Sy, int Ex, int Ey, int n, int m, Queue<Pair> q, char[][] grid, boolean[][] vis, Pair[][] parent){
        vis[Sx][Sy]=true;
        q.offer(new Pair(Sx, Sy));

        while(!q.isEmpty()){
            Pair p  = q.poll();
            int x = p.row;
            int y = p.col;
            if (x == Ex && y == Ey) {
                isPath = true;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny] && grid[nx][ny] != '#') {

                    vis[nx][ny] = true;
                    parent[nx][ny]=new Pair(x,y);
                    q.offer(new Pair(nx, ny));

                }
            }
        }

    }
}