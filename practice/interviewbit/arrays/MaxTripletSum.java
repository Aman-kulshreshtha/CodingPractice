package practice.interviewbit.arrays;

import java.util.*;

public class MaxTripletSum {

    public static void main(String[] args) {
        List<Integer> a = List.of(14,22649, 27447, 23806, 15891, 6730, 24371, 15351, 15007, 31102, 24394 ,3549 ,19630, 12624, 24085 );
        System.out.println(solve(a));

    }

    private static int solve(List<Integer> A) {

        int n = A.size();
        int[] right = new int[n];

        for(int i = n-1; i>= 0 ; i--) {
            right[i] = (i == n-1)?A.get(i):Math.max(A.get(i),right[i+1]);
        }


        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(A.get(0));
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i< n-1; i++) {
            if(ts.lower(A.get(i)) != null && A.get(i) != right[i]) {
                int a = ts.lower(A.get(i));
                if(a+A.get(i)+right[i+1] > ans ) {
                    ans = a+A.get(i)+right[i];
                    //System.out.println(a+"+"+A.get(i)+"+"+ right[i] + " = " + ans);
                }

            }

            ts.add(A.get(i));

        }

        return ans;

    }


}
