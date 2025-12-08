import java.util.*;

public class Frog1 {
    static int[] dp;
    static int[] h;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = new int[n];
        dp = new int[n];

        // Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        // System.out.println("Minimum cost: "+solve(0)); //i=0 starting point
        solve();
    }

    //DP- Memoization (Top down)
    // private static int solve(int i) {
    //     if (i == n - 1) return 0;          // reached last stone -- baseCase
    //     if (dp[i] != -1) return dp[i];

    //     int oneJump = solve(i + 1) + Math.abs(h[i] - h[i + 1]);

    //     int twoJump = Integer.MAX_VALUE;
    //     if (i + 2 < n) {
    //         twoJump = solve(i + 2) + Math.abs(h[i] - h[i + 2]);
    //     }

    //     return dp[i] = Math.min(oneJump, twoJump);
    // }


    //DP- Tabulation (Bottom up)
    // private static void solve() {
    //     dp[0]=0;
        
    //     for (int i = 1; i < n; i++) {
    //         //jum 1
    //         int cost1 = dp[i - 1] + Math.abs(h[i] - h[i - 1]);

    //         // Jump from 2
    //         int cost2 = Integer.MAX_VALUE;
    //         if (i > 1) {
    //             cost2 = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
    //         }

    //         dp[i] = Math.min(cost1, cost2);
    //     }
    //     System.out.println("Minimum cost: " + dp[n - 1]);
    // }


    // Space Optimization:
    private static void solve(){
        int prev = 0;      // dp[i-1]
        int prev2 = 0;     // dp[i-2] 

        for (int i = 1; i < n; i++) {

            
            int cost1 = prev + Math.abs(h[i] - h[i - 1]);

            // Cost 2
            int cost2 = Integer.MAX_VALUE;
            if (i > 1) {
                cost2 = prev2 + Math.abs(h[i] - h[i - 2]);
            }

            int curr = Math.min(cost1, cost2);

            prev2 = prev;
            prev = curr;
        }

        System.out.println("Minimum cost: " + prev);
    }


}


