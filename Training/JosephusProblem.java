class Solution {

    public int josephus(int n, int k) {
        return solve(n, k);
    }

    private int solve(int n, int k) {

        if (n == 1) return 1;

        int i = solve(n - 1, k);

        return (i + k - 1) % n + 1;
    }
}

// USING ARRAY circular;
import java.util.*;

class Solution {

    public int josephus(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();

        // fill array: [1, 2, 3, ..., n]
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        return solve(arr, k, 0);   // start from index 0
    }

    private int solve(ArrayList<Integer> arr, int k, int index) {

        // base case: only 1 person left
        if (arr.size() == 1) {
            return arr.get(0);
        }

        // next index to remove
        index = (index + k - 1) % arr.size();

        // remove the person at index
        arr.remove(index);

        // recursive call on reduced array
        return solve(arr, k, index);
    }
}
