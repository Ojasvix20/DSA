
import java.util.Arrays;
import java.util.Scanner;

public class LCS {

    static int[][] dp;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[m];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(LCSLen(0, 0, arr1, arr2));

        printLCS(0, 0, arr1, arr2);
    }

    public static int LCSLen(int i, int j, int[] arr1, int[] arr2) {
        if (i == n || j == m) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int skip = Math.max(LCSLen(i + 1, j, arr1, arr2), LCSLen(i, j + 1, arr1, arr2));
        int take = 0;

        if (arr1[i] == arr2[j]) {
            take = 1 + LCSLen(i + 1, j + 1, arr1, arr2);
        }

        return dp[i][j] = Math.max(take, skip);
    }

    public static void printLCS(int i, int j, int[] arr1, int[] arr2) {

        if (i == m || j == n)
            return;

        if (arr1[i] == arr2[j]) {
            System.out.print(arr1[i] + " ");
            printLCS(i + 1, j + 1, arr1, arr2);
        } else if (i + 1 < n && dp[i + 1][j] >= dp[i][j + 1]) {
            printLCS(i + 1  , j, arr1, arr2);
        } else {
            printLCS(i, j + 1, arr1, arr2);
        }
    }

}
