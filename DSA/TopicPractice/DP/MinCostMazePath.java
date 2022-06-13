package DSA.TopicPractice.DP;

public class MinCostMazePath {

    public static void main(String[] args) {

    }

    private static int minCostPath(int[][] maze) {
        int x = 0,y =0 ;
        int m = maze.length,n = maze[0].length;
        int[][] dp = new int[m][n];

        // assign meaning to each cell
        //dp[i][j] = min cost to reach bottom right cell from i , j

        for(int i = m-1; i>= 0 ; i--) {
            for(int j = n-1; j>= 0; j--) {

                if(i == m-1&& j == n-1) {
                    dp[i][j] = maze[i][j];
                }else if(i == m-1) {
                    dp[i][j] = maze[i][j] + dp[i][j+1];
                }else if(j == n-1) {
                    dp[i][j] = maze[i][j] + dp[i+1][j];
                }else {
                    dp[i][j] = maze[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
                }

            }
        }

        return dp[0][0];

    }
}
