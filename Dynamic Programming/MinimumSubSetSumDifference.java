// User function Template for Java
import java.util.*;
class MinimumSubSetSumDifference {
    static int[][] dp;
    static int sum;

    public int minDifference(int arr[]) {
        // Your code goes here
        sum=0;
        for(int i: arr) sum+=i;
        dp = new int[arr.length+1][sum+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0,0,arr);
    }
    // recurr: 
    
    // public static int solve(int i, int currSum, int[] arr){
    //     if(i==arr.length){
    //         int s2= sum-currSum;
    //         return Math.abs(currSum-s2);
    //     }
    //     int notTake = solve(i+1, currSum, arr);
    //     int take = solve(i+1, currSum+arr[i], arr);
    //     return Math.min(take, notTake);
    // }
    
    // TOP DOWN:
    public static int solve(int i, int currSum, int[] arr){
        if(i==arr.length){
            int s2= sum-currSum;
            return Math.abs(currSum-s2);
        }
        if(dp[i][currSum]!=-1) return dp[i][currSum];
        int notTake = solve(i+1, currSum, arr);
        int take = solve(i+1, currSum+arr[i], arr);
        return dp[i][currSum] = Math.min(take, notTake);
    }
}
