package practice.interviewbit.TwoPointer;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ArrayList<Integer> A =new ArrayList<>();

        A.add(-1);
        A.add(2);
        A.add(1);
        A.add(4);
//        A.add(8);
//        A.add(11);
//        A.add(13);
//        A.add(17);
//        A.add(21);
//        A.add(22);
//        A.add(37);

        System.out.println(threeSumClosest(A,1));

    }
    public static int threeSumClosest(ArrayList<Integer> A, int B) {

        // sort array
        Collections.sort(A);

        int ans = A.get(0) + A.get(1);

        for(int i = 0 ; i < A.size()-2; i++) {
            int fix = A.get(i);
            int second = twoSum(A,i+1,B-fix);
            //System.out.println("for "+ fix +" closest = " +second );
            int sum = fix + second;

            ans = (Math.abs(B-sum) < Math.abs(B-ans))? sum:ans;
            //System.out.println(fix+" + "+second+" = "+ sum);
        }
        return ans;

    }

    private static int twoSum(ArrayList<Integer> A, int start, int x) {
        int ans = A.get(start) + A.get(start+1);

        for(int i = 0 ; i < A.size()-1; i++) {
            int fix = A.get(i);
            int second = findClosest(A,i+1,x-fix);
          //  System.out.println("for "+ fix +" closest = " +second );
            int sum = fix + second;

            ans = (Math.abs(x-sum) < Math.abs(x-ans))? sum:ans;
            //System.out.println(fix+" + "+second+" = "+ sum);
        }
        return ans;
    }

    private static int findClosest(ArrayList<Integer> A, int start, int x) {
        int l = start,r = A.size() - 1 ;

        while(l <= r)  {
            int mid = (l+ (r-l)/2 );

            if(x < A.get(mid)) {
                r = mid-1;
            }else if(x == A.get(mid)) {
                return x;
            }else {
                l = mid+1;
            }

        }

        if(r<= start) {
            return A.get(l);
        }

        if(l >= A.size()) {
            return A.get(r);
        }

        return ( Math.abs(x-A.get(l)) < Math.abs(x-A.get(r)) )? A.get(l) : A.get(r);
    }
}
