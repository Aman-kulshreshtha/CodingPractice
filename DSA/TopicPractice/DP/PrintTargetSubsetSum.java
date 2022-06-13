package DSA.TopicPractice.DP;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.*;

class PrintTargetSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(),target = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++ ) {

            arr[i] = sc.nextInt();

        }

        // logic for subset sum dp
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i = 0 ; i < n+1 ; i++) {
            for(int j = 0 ; j < target+1 ; j++) {

                if(i==0 && j == 0) {
                    dp[i][j] = true;
                }else if(i == 0) {
                    dp[i][j] = false;
                }else if(j == 0 ) {
                    dp[i][j] = true;
                }else {
                    if(j >= arr[i-1]) {
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }

                }

            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target ; j++) {
                System.out.print(dp[i][j] +"\t");
            }
            System.out.println();
        }

        Queue<Pair> q = new ArrayDeque<>();

    }
}

class Pair {
    String psf;
    int i;
    int j;

    Pair(String psf, int i , int j) {
        this.psf = psf;
        this.i = i;
        this.j = j;
    }
}