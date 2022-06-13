package Days30Companies6.amazon;

import java.util.*;

public class MaximumProfit {

    

     static int maxProfit(int K, int N, int A[]) {
        
       int[][] dp = new int[K+1][N];
       
       for(int i = 1; i <= K ; i++) {
           for(int j = 1; j < N ; j++) {

               int prev = dp[i][j-1];
               
               int maxPrev = dp[i-1][j-1];
               for(int k = 0 ; k <= j-1; k++) {

                   maxPrev = Math.max(maxPrev, dp[i-1][k] + A[j]-A[k]);
                   dp[i][j] = Math.max(prev,maxPrev);

               }

           }
       }
       
    //   for(int i = 0 ; i <= K;i++) {
           
    //       for(int j = 0 ; j < N ; j++) {
    //           System.out.print(dp[i][j]+" ");
    //       } 
           
    //       System.out.println();
           
    //   }
        return dp[K][N-1];

    }

}