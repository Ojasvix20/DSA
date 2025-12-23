import java.util.*;

public class Main {
    static int[][] dp;
    static int m, n;
    static String s1, s2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        m = s1.length();
        n = s2.length();

        dp = new int[m + 1][n + 1];

        // Build DP table (bottom-up)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // Reconstruct ONE LCS only
        StringBuilder lcs = new StringBuilder();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                lcs.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(lcs.toString());
    }
}
