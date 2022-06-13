package DSA.TopicPractice.DP;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,3,5};
        int target = 10;
        System.out.println(coinPermutation(coins,target));
    }

    private static int coinPermutation(int[] coins, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;


        for(int coin =1; coin <= coins.length;coin++) {
           for(int j= 0 ;j <= target; j++) {
               if(j-coins[coin-1] >= 0) {
                   dp[j] += dp[j-coins[coin-1]];
               }
           }
        }

        return dp[target];

    }

    private static int KnapSack(int[] weight, int[] val, int W) {
        int n = weight.length;

        int[][] dp = new int[n+1][W+1];
        for(int i = 0 ; i <= n; i++) {
            for(int j = 0 ; j <= W; j++) {
                if(i == 0|| j == 0) {
                    dp[i][j] = 0;
                }else {
                    if(val[i-1] > W) {
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i-1][j-val[i-1]]);
                    }
                }
            }
        }

        return dp[n][W];
    }
    private static int numberOfCombinations(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n+1][target+1];

        for(int size= 0 ; size<= n ; size++) {
            for(int t = 0 ; t <= target; t++) {
                if(t == 0) {
                    dp[size][t] = 1;

                }else if(size == 0) {
                    dp[size][t] = 0;
                }else {
                    if(t-coins[size-1] >= 0) {
                        dp[size][t] = dp[size][t-coins[size-1]]+ dp[size-1][t];
                    }else {
                        dp[size][t] = dp[size-1][t];
                    }

                }
            }
        }

        return dp[n][target];
    }
}
