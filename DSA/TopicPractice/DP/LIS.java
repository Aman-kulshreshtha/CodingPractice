package DSA.TopicPractice.DP;
import java.util.*;
public class LIS {

    public static void main(String[] args) {
        int[] arr = {10,22,9,33,21,50,41,60,80,1};
        lis(arr,arr.length);
    }

    private static void lis(int[] arr, int n ) {
        int[] dp = new int[n];
        int ans = 1;
        Arrays.fill(dp,1);
        for(int i = 1; i < n ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(arr[j] < arr[i]) {
                    int x  = 1+dp[j];
                    dp[i] = Math.max(dp[i],x);
                }
            }

            ans = Math.max(ans,dp[i]);
        }
        int start = n-1;
        Queue<PairBFS> q = new ArrayDeque<>();

        for( ; start>= 0 ; start-- ) {
            if(dp[start] == ans) {
                ArrayList<Integer> a = new ArrayList<>();

                q.add(new PairBFS(arr[start],dp[start],start,a));
            }
        }
        while(!q.isEmpty()) {

            PairBFS node = q.remove();

            node.psf.add(node.val);

            for(int i = node.idx -1 ; i >= 0 ; i--) {

                if(dp[i] == node.lis-1) {
                    q.add(new PairBFS(arr[i],dp[i],i,new ArrayList<>(node.psf)));
                }

            }

            if(node.lis == 1) {
                System.out.println(node.psf);
            }



        }


    }
}

class PairBFS {
    int val;
    int lis;
    int idx;
    ArrayList<Integer> psf;

    public PairBFS(int v , int l ,int idx ,ArrayList<Integer> p) {
        val = v;
        lis = l;
        this.idx = idx;
        psf = p;

    }
}