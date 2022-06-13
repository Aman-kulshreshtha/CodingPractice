package DSA.TopicPractice.DP;

import java.util.*;

public class LargestOneSubSquare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        int[][] mat = new int[m][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = mat[i][j];
                } else {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, dp[i - 1][j]);
                    min = Math.min(min, dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.print(ans);

    }

}