import java.util.Arrays;

public class PartitionEqualSubsetSum {

    // static int[][] dp;
    // int n;

    public boolean canPartition(int[] nums) {
        // n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        // dp = new int[n + 1][target + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solve(0, target, nums);
        return solveBU(target, nums);

    }
    // recurrsion
    // public static boolean solve(int i, int target, int[] nums){
    // if (target==0) return true;
    // if(i==nums.length) return false;

    // boolean take = solve(i+1, target - nums[i] , nums);
    // boolean notTake = solve(i+1, target , nums);

    // return (take || notTake);
    // }

    // TOP DOWN
    // public static boolean solveTD(int i, int target, int[] nums) {
    // if (target == 0)
    // return true;
    // if (i == nums.length)
    // return false;
    // if (dp[i][target] != -1)
    // return dp[i][target] == 1;

    // boolean notTake = solve(i + 1, target, nums);
    // boolean take = false;
    // if (nums[i] <= target) {
    // take = solve(i + 1, target - nums[i], nums);

    // }

    // dp[i][target] = (take || notTake) ? 1 : 0;
    // return dp[i][target] == 1;
    // }

    // bottom up
    public static boolean solveBU(int target, int[] nums) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // not take - copyy above value;
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}