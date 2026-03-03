import java.util.*;
import java.io.*;

class Pair{
    int r,c;
    Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}

public class Monster{
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,1,-1};
    static char[] dir = {'U','D','R','L'};
    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        
        boolean escaped = false;
        int[] exitPoint = new int[2];
        int[] start = new int[2];

        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            String row = br.readLine();   // read whole line
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);  // take char
            }
        }

        int[][] monsterTime = new int[n][m];
        for(int[] row: monsterTime) Arrays.fill(row,Integer.MAX_VALUE);
        char[][] parent = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        //mulit source bfs -- offer all M into queue;
        
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='M'){
                    q.offer(new Pair(i,j));
                    monsterTime[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int d=0;d<4;d++){
                int nr = r+ dirX[d];
                int nc = c+ dirY[d];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]!='#' && monsterTime[nr][nc]> monsterTime[r][c]+1){
                    monsterTime[nr][nc]=monsterTime[r][c]+1;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
        q= new ArrayDeque<>();

        // single source bfs from A:
        for(int i=0; i<n;i++){
            for(int j=0; j<m ; j++){
                if(grid[i][j]=='A'){
                    q.offer(new Pair(i,j));
                    start[0]=i;
                    start[1]=j;
                    visited[i][j]=true;
                }
            }
        }
        int[][] dist = new int[n][m];
        // for(int[] row: dist) Arrays.fill(row,0) ;

        while(!q.isEmpty() && !escaped){
            Pair curr=  q.poll();
            int r= curr.r;
            int c= curr.c;

            if(r==0 || c==0|| r==n-1 || c==m-1){
                escaped= true;
                exitPoint[0]=r; 
                exitPoint[1]=c; 
                break;
            }
            for(int d = 0; d<4; d++){
                int nr = r+ dirX[d];
                int nc = c+ dirY[d];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]!='#' && !visited[nr][nc] && dist[r][c]+1< monsterTime[nr][nc]){
                    visited[nr][nc ]= true;
                    dist[nr][nc]=  dist[r][c]+1;
                    parent[nr][nc] = dir[d];
                    q.offer(new Pair(nr,nc));
                }
            }
        }
        if(!escaped){
            System.out.println("NO");
            return ;
        }


        StringBuilder path = new StringBuilder();
        int currX=exitPoint[0];
        int currY=exitPoint[1];
        while(currX!=start[0] ||  currY!=start[1]){
            char direction = parent[currX][currY];
            path.append(direction);
            int idx=-1;
            for(int i=0; i<4; i++){
                if(dir[i]==direction) idx=i;
            }

            currX -= dirX[idx];
            currY -= dirY[idx];

        }   
        // reverse path
        path.reverse();

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}