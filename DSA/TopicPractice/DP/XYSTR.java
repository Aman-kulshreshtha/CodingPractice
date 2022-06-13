package DSA.TopicPractice.DP;

import java.util.*;

public class XYSTR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String st = sc.next();
            int[] dp = new int[st.length() + 1];
            Arrays.fill(dp, -1);
            System.out.println(solve(st, st.length(), dp));
            

        }

        
    }

    private static int solve(String s, int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];

        if (n <= 1) {
            dp[n] = 0;
            return dp[n];
        }

        if (s.charAt(n - 2) == s.charAt(n - 1)) {
            dp[n] = solve(s, n - 1, dp);
            return dp[n];
        } else {
            dp[n] = Math.max(solve(s, n - 1, dp), 1 + solve(s, n - 2, dp));
            return dp[n];
        }

    }

}
