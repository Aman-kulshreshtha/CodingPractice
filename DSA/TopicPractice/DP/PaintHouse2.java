package DSA.TopicPractice.DP;

import java.util.*;

public class PaintHouse2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[][] matrix = new int[n][x];


        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < x ; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(paintHouse(matrix));
    }

    private static int paintHouse(int[][] matrix) {

        // given matrix
        /*
        * 1 2 3 4 5
        * 5 4 3 2 1
        * 2 5 4 3 1
        * */

        int rows = matrix.length;
        int cols = matrix[0].length;



        // ans matrix dp
        /*    0  1  2
        * c1  1
        * c2  2
        * c3  3
        * c4  4
        * c5  5
        * */


        int[][] dp = new int[cols][rows];

        for(int row = 0 ; row < dp.length;row++) {
            dp[row][0] = matrix[0][row];
        }

        for(int col = 1; col < dp[0].length;col++) {
            for(int row = 0 ; row < dp.length; row++) {
                int ans = Integer.MAX_VALUE;

                for(int i = 0 ; i < dp.length; i++) {
                    if(i != row) {
                        ans = Math.min(dp[i][col-1], ans);
                    }
                }
                dp[row][col] = ans + matrix[col][row];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < dp.length;i++) {
            ans = Math.min(ans,dp[i][dp[0].length-1]);
        }

        return ans;

    }
}
