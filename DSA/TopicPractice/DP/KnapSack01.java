package DSA.TopicPractice.DP;

import java.util.*;

public class KnapSack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];

        for(int i = 0 ; i < n ; i++) {
            w[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < n ; i++) {
            v[i] = sc.nextInt();
        }

        int W = sc.nextInt();

        int[][] dp = new int[n+1][W+1];


        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <= W ; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }else if(w[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], v[i-1] + dp[i-1][j-w[i-1]]);
                }
            }    
        }

        for(int i = 0 ; i <= n  ; i++) {

            for(int j = 0 ; j <= W ; j++) {
                System.out.print(dp[i][j]+ "\t");                
            }

            System.out.println();   
                     
        }

        // printing the objects:

        for(int i = n, j = W ; i>= 0 && j >= 0; ){
           // System.out.println("checking : " +i+" "+j);
            if(i == 0 || j ==0) {
                break;
            }

            if(j < w[i-1]) {
                //System.out.println(v[i-1]);
                i = i-1;
            }else {
                if(dp[i-1][j] == dp[i][j]) {
                    i = i-1;
                }else {
                    System.out.println("value: "+v[i-1] +" weight: "+ w[i-1]);
                    j = j- w[i-1];
                    i = i-1;

                }
            }

        }


    }
}