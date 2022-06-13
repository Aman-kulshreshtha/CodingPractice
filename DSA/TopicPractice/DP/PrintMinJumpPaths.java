package DSA.TopicPractice.DP;

import java.util.*;

public class PrintMinJumpPaths {
    public static void Solution(int arr[]){

        int[] dp = new int[arr.length];

        for(int j =arr.length-1 ; j >= 0 ; j--) {
            if(j == arr.length-1) {
                dp[j] = 0;
            }else {
                int ans = Integer.MAX_VALUE-1;
                for(int i = 1 ; i <= arr[j] ; i++) {
                    if(i+j < arr.length) {
                        ans = Math.min(ans, 1+ dp[i+j]);
                    }

                }

                dp[j] = ans;
            }

        }

        System.out.println(dp[0]);
        StringBuilder pathSoFar = new StringBuilder("0");
        printPath(pathSoFar,0,arr.length-1,arr,dp);



    }

    private static void printPath(StringBuilder pathSoFar, int current, int dest, int[] arr, int[] dp) {
        if(current == dest) {
            StringBuilder path = new StringBuilder(pathSoFar.toString());
            if(current != 0){
                path.append("->").append(current);
            }
            System.out.println(path.toString());

        }else if(current > dest) {
        }else {
            StringBuilder path = new StringBuilder(pathSoFar.toString());
            if(current != 0)
            path.append("->").append(current);
            for(int i = 1 ; i <= arr[current] ; i++ ) {
                if(current+i < arr.length) {
                    if(dp[current+i] +1 == dp[current]) {
                        printPath(path,current+i,dest,arr,dp);
                    }
                }
            }
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
