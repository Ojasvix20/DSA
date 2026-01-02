
public class SubSetSum {
    // static int[][] dp;

    public static void main(String[] args) {
        System.out.println(subsetSumToK(4, 5, new int[] { 4, 3, 2, 1 }));
        System.out.println(subsetSumToK(5, 4, new int[] { 2, 5, 1, 6, 7 }));
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        // dp = new int[n + 1][k + 1];
        // for(int row[] : dp){
        // Arrays.fill(row,-1);

        // }

        // return recurrsion(0,n,arr,k);
        // return topDown(0,n,arr,k);
        // return bottomUp(n, arr, k);
        return SpaceOptimized(n, arr, k);
    }

    // recurr:

    // static boolean recurrsion(int i, int n, int[] arr, int k) {
    // if (k == 0)
    // return true;

    // if (k < 0 || i == n)
    // return false;

    // return (recurrsion(i + 1, n, arr, k - arr[i]) || recurrsion(i + 1, n, arr,
    // k));

    // }

    // top down

    // static boolean topDown(int i, int n, int[] arr, int k) {
    // if (k == 0)
    // return true;

    // if (k < 0 || i == n)
    // return false;

    // if (dp[i][k] != -1) {
    // return dp[i][k] == 1;
    // }

    // boolean take = topDown(i + 1, n, arr, k - arr[i]);
    // boolean notTake = topDown(i + 1, n, arr, k);

    // dp[i][k] = (take || notTake) ? 1 : 0;

    // return dp[i][k] == 1;
    // }

    // bottom up
    // public static boolean bottomUp(int n, int[] arr, int k) {

    // boolean[][] dp = new boolean[n + 1][k + 1];

    // // base case: sum 0 is always possible
    // for (int i = 0; i <= n; i++) {
    // dp[i][0] = true;
    // }
    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= k; j++) {

    // if (arr[i - 1] <= j) {
    // dp[i][j] = dp[i - 1][j] || dp[i-1][j - arr[i - 1]];
    // } else {
    // dp[i][j] = dp[i - 1][j];
    // }
    // }
    // }
    // return dp[n][k];
    // }

    // SPace Optimized
    public static boolean SpaceOptimized(int n, int[] arr, int k) {
        boolean[] dp = new boolean[k+1];

        dp[0]=true;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[k];
    }
}
