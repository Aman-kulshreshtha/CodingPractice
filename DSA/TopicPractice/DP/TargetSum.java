package DSA.TopicPractice.DP;

public class TargetSum {

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12};
        int target = 15;
        System.out.println(targetSum(arr,target));
    }

    private static boolean targetSum(int[] arr, int target) {
        int n = arr.length;

        int[][] dp = new int[n+1][target+1];

        for(int size = 0 ; size <= n ; size++) {
            for(int t = 0 ; t <= target;t++) {

                if(t==0) {
                    dp[size][t] = 1;
                }else if(size == 0) {
                    dp[size][t] = 0;
                }else {
                    if(t-arr[size-1] >= 0 ) {
                        dp[size][t] = (dp[size-1][t] | dp[size-1][t-arr[size-1]] );
                    }else {
                        dp[size][t] = dp[size][t];
                    }

                }

            }
        }

        return (dp[n][target]==1);

    }
}
