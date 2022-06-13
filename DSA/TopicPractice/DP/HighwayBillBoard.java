package DSA.TopicPractice.DP;

import java.util.*;

public class HighwayBillBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int n = sc.nextInt();
        int[] board = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            board[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int dist = sc.nextInt();
        int ans = Integer.MIN_VALUE;

        int[] dp = new int[n];

        for (int i = 0; i < dp.length; i++) {
            int max = cost[i];
            for (int j = 0; j < i; j++) {
                if (board[i] - board[j] > dist) {
                    max = Math.max(max, dp[j] + cost[i]);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);

    }
}