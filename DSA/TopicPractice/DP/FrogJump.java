package DSA.TopicPractice.DP;

import java.util.Arrays;

public class FrogJump {
    private static int frogJump(int n, int heights[]) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return cost(heights,n,dp);

    }
    private static int cost(int[] heights, int n , int[] dp) {

        if(n <= 0) return 0;
        if(n == 1) return 0;
        if(n == 2) {
            dp[2] = Math.abs(heights[1]-heights[0]);
            return dp[2];
        }

        if(dp[n] != -1) return dp[n];

        int cost1 = cost(heights,n-1,dp);
        int cost2 = cost(heights,n-2,dp);

        dp[n] = Math.min( cost1 + Math.abs(heights[n-1]-heights[n-2]),cost2+ Math.abs(heights[n-1]-heights[n-3]));
        return dp[n];
    }
}
