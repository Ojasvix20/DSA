public class KnapSack01 {

    // recurrsive
    static int knapsack(int[] wt, int[] val, int n, int W) {
        // base case
        if (n == 0 || W == 0)
            return 0;

        // if current item weight is more than capacity
        if (wt[n - 1] > W)
            return knapsack(wt, val, n - 1, W);

        // choose max of take or not take
        return Math.max(
                val[n - 1] + knapsack(wt, val, n - 1, W - wt[n - 1]),
                knapsack(wt, val, n - 1, W));
    }

    // Memoization - 2d dp:
    static int[][] dp;

    static int knapsack(int[] wt, int[] val, int n, int W) {
        // base case
        if (n == 0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];
        // if current item weight is more than capacity
        // cannot take current item
        if (wt[n - 1] > W) {
            return dp[n][W] = knapsack(wt, val, n - 1, W);
        }

        // can take or not take
        int take = val[n - 1] + knapsack(wt, val, n - 1, W - wt[n - 1]);
        int notTake = knapsack(wt, val, n - 1, W);

        return dp[n][W] = Math.max(take, notTake);
    }

}
