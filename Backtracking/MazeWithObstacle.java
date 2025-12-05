import java.util.ArrayList;

public class MazeWithObstacle{
    static ArrayList<String> list;
    public static void main(String[] args){
        list=new ArrayList<>();
        boolean[][] maze = new boolean[][]{
            {true, true, true},
            {true,false,true},
            {true,true,true}};
        System.out.println(solve("", maze,0 ,0));
    }
    static ArrayList<String> solve(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            list.add(p);
            return list;
        }
        if(!maze[r][c]) return new ArrayList<>();
        if(r<maze.length-1){
            solve(p+'D', maze, r+1, c);
        }
        if(c<maze[0].length-1){
            solve(p+'R', maze, r, c+1);
        }
        return list;
    }
}