package practice.random;

public class FindRecursiveSumEven {

    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    private static int sumEven(int a , int b) {



        // sum of even between 0 and a
        int sum1= sum(a);

        int sum2 = sum(b);

        int ans = sum2 - sum1;

        // what if a is even ?
        // we must include it in ans
        if(a%2 == 0)
        ans += a;

        return ans;


    }

    private static int sum(int a) {
        if(a <= 0) return 0;
        if(a%2 == 0) {
            return a+ sum(a-2);
        }else {
            return sum(a-1);
        }
    }
}
