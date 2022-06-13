package Days30Companies6.adobe;

public class GoldPotGame {

    public static void main(String[] args) {
        int[] A = {8, 15, 3, 7};

        System.out.println(maxCoins(A,A.length));
    }
    public static int maxCoins(int A[],int n)
    {
        //add code here.
        int[][][] dp = new int[n+1][n+1][2];
        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                for(int k = 0 ;k <=1 ; k++) {
                    dp[i][j][k] =-1;
                }
            }
        }
        return solve(A,0,n-1,1,dp);

    }

    private static int solve(int[] A, int i, int j, int turnX,int[][][] dp) {
        if(dp[i][j][turnX] != -1) return dp[i][j][turnX];

        if(i > j) {
            return 0;
        }
        if(i == j) {
            if(turnX == 1) return A[i];
            else return 0;
        }
        if(turnX == 1) {
            int cost1 = A[i] + solve(A,i+1,j, 0,dp);
            int cost2 = A[j] + solve(A,i,j-1, 0,dp);
            dp[i][j][turnX] = Math.max(cost1,cost2);
            return dp[i][j][turnX];
        }else {
            int cost1 = solve(A,i+1,j, 1,dp);
            int cost2 = solve(A,i,j-1, 1,dp);
            dp[i][j][turnX] = Math.min(cost1,cost2);
            return dp[i][j][turnX];
        }

    }
}
