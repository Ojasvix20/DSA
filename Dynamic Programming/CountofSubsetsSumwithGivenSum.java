import java.util.Arrays;

public class CountofSubsetsSumwithGivenSum {
    static int[][] dp;
    static int n;
    static final int MOD = 1_000_000_007;

    public int perfectSum(int[] nums, int target) {
        // code here
        n = nums.length;
        dp = new int[n + 1][target + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(0, target, nums);
        // return ans;

        return solveBU(target, nums);
    }

    // top down
    public static int solve(int i, int target, int[] nums) {

        if (i == n) {
            return target == 0 ? 1 : 0;
        }
        if (dp[i][target] != -1)
            return dp[i][target];

        int notTake = solve(i + 1, target, nums);
        int take = 0;
        if (nums[i] <= target) {
            take = solve(i + 1, target - nums[i], nums);
        }

        return dp[i][target] = take + notTake;
    }

    // bottom up
    public static int solveBU(int target, int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (nums[i - 1] <= t) {
                    take = dp[i - 1][t - nums[i - 1]];
                }
                dp[i][t] = (take + notTake) % MOD;
            }
        }
        return dp[n][target];
    }

}
