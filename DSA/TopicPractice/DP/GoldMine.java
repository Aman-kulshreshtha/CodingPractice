package DSA.TopicPractice.DP;

public class GoldMine {

    public static void main(String[] args) {
        int[][] maze = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(goldMine(maze));
    }
    private static int goldMine(int[][] maze) {
        // we will solve by tabulation
        // assign storage and meaning to each cell of storage
        //dp[i][j] max gold that can be accomodated when we start digging from that cell towards right

        int m = maze.length,n = maze[0].length;

        int[][] dp = new int[m][n];

        for(int j = n-1;j >= 0; j--) {
            for(int i = m-1;i>= 0 ; i--) {
                if(j == n-1) {
                    dp[i][j] = maze[i][j];
                }else if(i == n-1) {
                    dp[i][j] = maze[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                }else if(i == 0) {
                    dp[i][j] = maze[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else {
                    int ans = dp[i][j+1];
                    ans = Math.max(ans,dp[i+1][j+1]);
                    ans = Math.max(ans,dp[i-1][j+1]);
                    dp[i][j] = maze[i][j] +  ans;

                }
            }
        }

        int max = dp[0][0];
        for(int i = 0 ; i < m ; i++) {
            max = Math.max(max,dp[i][0]);
        }

        for (int i = 0 ; i < m ; i++) {
            for(int j = 0;j < n ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return max;
    }
}
