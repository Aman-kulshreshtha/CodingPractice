package LanguageBasics.core;

public class ncr {

    public static void main(String[] args) {
        System.out.print(NCR(4, 2));
    }

    private static int NCR(int n, int r) {
        int[] dp = new int[r + 1];

        dp[0] = 1;
        for (int i = 1; i <= r; i++) {

            dp[i] = (dp[i - 1] * n) / i;
        }

        for (int x : dp) {
            System.out.print(x + " ");

        }
        System.out.println();

        return dp[r];
    }

}
