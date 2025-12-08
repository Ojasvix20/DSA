import java.util.*;

public class MazePrintPath {

    public static void main(String[] args) {
        ArrayList<String> paths = findPaths("", 3, 3); // 3x3 grid
        System.out.println(paths);
    }

    public static ArrayList<String> findPaths(String p, int r, int c) {
        // Base case: we reached the bottom-right cell
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        // Move Down (Vertical)
        if (r > 1) {
            list.addAll(findPaths(p + 'V', r - 1, c));
        }

        // Move Right (Horizontal)
        if (c > 1) {
            list.addAll(findPaths(p + 'H', r, c - 1));
        }

        return list;
    }
}
