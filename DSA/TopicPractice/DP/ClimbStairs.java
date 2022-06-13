package DSA.TopicPractice.DP;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbStairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        int[] steps = new int[n];
        for(int i = 0 ; i < n ; i++) {
            steps[i] = sc.nextInt();
        }

        System.out.println(climbMinTabulationVariable(n,steps));


//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println("Solution from Recursion: " + climbStairsRecursive(n));
//        System.out.println("SOlution from memo dp: "+ climbMemo(n,dp));
//        System.out.println("Solution from tabulation dp: "+ climbTabulation(n));
    }

    private static int climbStairsRecursive(int n ) {
        if(n == 0 ) return 1;
        if(n < 0) return 0;

        return climbStairsRecursive(n-1)+climbStairsRecursive(n-2)+ climbStairsRecursive(n-3);

    }


    private static int climbMemo(int n , int[] dp ){
        if(n == 0 ) return 1;
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int x= climbStairsRecursive(n-1)+climbStairsRecursive(n-2)+ climbStairsRecursive(n-3);
        dp[n] = x;

        return x;
    }

    private static int climbTabulation(int n ) {
        int[] dp = new int[n+1];
        for(int i = 0 ; i<= n ; i++) {
            if(i == 0) {
                dp[i] = 1;
            }else  {
                dp[i] = ((i-1 < 0)?0:dp[i-1]) + ((i-2 < 0)?0:dp[i-2])+((i-3 < 0)?0:dp[i-3]);
            }
        }

        return dp[n];
    }

    private static int climbTabulationVariable(int n , int[] steps) {
        // n = 6
        // steps[6] : 3 3 0 2 2 3

        int[] dp = new int[n+1];
        for(int i = n ; i >= 0; i--) {
            if(i == n) {
                dp[i] = 1;
            }else {
                int ans = 0;
                for(int step = 1; step < steps[i]; step++ ) {
                    if(i+step > n) {
                        ans += 0;
                    }else {
                        ans += dp[i+step];
                    }
                }

                dp[i] = ans;

            }


        }

        return dp[0];

    }

    private static int climbMinTabulationVariable(int n , int[] steps) {

        int[] dp = new int[n+1];
//        assume n = 6
//        steps[]: 4 2 0 2 2 3
//        dp[]   : 0 0 0 0 0 0 0

        //assign meaning to each cell of dp
        // dp[i] = min steps to reach 6th step from ith step
        // small problem go from 6 to 6
        //large problem go from 0 to 6

        for(int i = n; i >= 0 ; i--) {
            if(i == n) {
                dp[i] = 0;
            }else {
                int ans = Integer.MAX_VALUE-1;

                for(int step = 1; step<= steps[i] && i+step <= n; step++) {
                    ans = Math.min(ans,1+dp[i+step]);
                }

                dp[i] = ans;
            }
        }
//
//        for(int x : dp) {
//            System.out.print(x+" ");
//        }
//        System.out.println();
        return dp[0];

    }
}
