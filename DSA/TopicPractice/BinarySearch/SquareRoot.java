package DSA.TopicPractice.BinarySearch;

public class SquareRoot {
    public static int sqrt(int A) {
         int i =0;
         int x =i*i;
         for(; x >= 0 && x < Integer.MAX_VALUE; i++) {
             x = i*i;
         }

         int[] dp = new int[i-1];
         int l = 0,r = dp.length-1;

        int ans = -1;
        while(l <= r) {

            int mid = l + (r-l)/2;
           // System.out.println("l: "+l+ " r: "+r+ " mid: "+mid);


            x = mid*mid;
            if(x > A && x > 0) {
                r = mid-1;
            }else if(x ==A) return mid;
            else {
                ans = mid;
                l = mid+1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        System.out.println(sqrt(255));
    }
}
