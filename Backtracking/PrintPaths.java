
import java.util.ArrayList;

public class PrintPaths {
    public static void main(String[] args) {
        // path("", 3, 3);        
        System.out.println(pathList("", 3, 3));        
        System.out.println(pathDiagonal("", 3, 3));        
    }
    public static void path(String p, int r, int c) {
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1){
            path(p+'D', r-1, c);
        }
        if(c>1){
            path(p+'R', r, c-1 );
        }
    }
    public static ArrayList<String> pathList(String p, int r, int c) {
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            // down
            list.addAll(pathList(p+'D', r-1, c));
        }
        if(c>1){
            // right
            list.addAll(pathList(p+'R', r, c-1));
        }

        return  list;
    }
    public static ArrayList<String> pathDiagonal(String p, int r, int c) {
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        ArrayList<String> list = new ArrayList<>();
        if(r>1 && c>1){
            // diagonal
            list.addAll(pathDiagonal(p+'D', r-1, c-1));
        }
        if(r>1){
            // vertical down
            list.addAll(pathDiagonal(p+'V', r-1, c));
        }
        if(c>1){
            // horizontal right
            list.addAll(pathDiagonal(p+'H', r, c-1));
        }

        return  list;
    }
}
