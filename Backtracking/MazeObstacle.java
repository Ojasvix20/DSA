import java.util.*;;

public class MazeObstacle {

    public static void main(String[] args) {

    }

    public static ArrayList<String> findPaths(int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if (r > 1) {
            // vertical down
            list.addAll(findPaths(p + 'V', r - 1, c));
        }
        if (c > 1) {
            // horizontal right
            list.addAll(findPaths(p + 'H', r, c - 1));
        }
    }
}




