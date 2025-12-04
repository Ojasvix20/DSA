import java.util.*;
class Combinations {
    static List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        // solve(1, n, k, temp);
        solve2(1, n, k, temp);
        return result;
    }

    public static void solve(int start, int n, int k, ArrayList<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp)); //add a COPY
            return;
        }

        if (start > n)
            return;

        temp.add(start);
        solve(start + 1, n, k - 1, temp);
        temp.remove(temp.size() - 1);
        solve(start + 1, n, k, temp);
    }

    public static void solve2(int start, int n, int k, ArrayList<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp)); //add a COPY
            return;
        }

        if (start > n)
            return;

        for (int i = start; i <= n; i++) {
            temp.add(i);
            solve(i + 1, n, k - 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}