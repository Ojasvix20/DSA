import java.util.*;

class printDivisor {
    public int[] divisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                if (i != n / i) ans.add(n / i); // avoid duplicate for perfect squares
            }
        }

        Collections.sort(ans); // to return divisors in ascending order

        // Convert ArrayList<Integer> to int[]
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
