package DSA.TopicPractice.DP;

public class CountBinaryStrings {

    public static void main(String[] args) {
        System.out.println(countBinaryString(6));
    }

    private static  int countBinaryString(int n ) {
        // we have to count all possible binary strings of length n that don't have consecutive 0's

        int[][] dp = new int[2][n+1];

        for(int i = 0 ; i <= n ; i++) {
            if(i == 0) {
                dp[0][i] = 0;
                dp[1][i] = 0;
            }else if(i == 1) {
                dp[0][i] = 1;
                dp[1][i] = 1;
            }else{
                dp[1][i] = dp[0][i-1] + dp[1][i-1];
                dp[0][i] = dp[1][i-1];
            }
        }


        return dp[0][n] + dp[1][n];
    }
}
