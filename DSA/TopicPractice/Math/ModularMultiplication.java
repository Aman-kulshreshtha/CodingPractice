package DSA.TopicPractice.Math;

public class ModularMultiplication {

    public static void main(String[] args) {
        System.out.println(fastPower(2,10));
    }

    private static int fastPower(int a, int b) {
        int res = 1;

        while(b > 0) {
            if( (b&1) != 0 ) {
                res *= a;

            }

            a = a*a;
            b = b>>1;

        }

        return res;
    }


    private static int modMultiplication(int a , int b , int m) {
        // return (a*b)mod m
        a = a%m;

        if(b == 1) return a;
        else if(b == 0) return 0;

        if(b%2 == 0) {
            return modMultiplication(a,b/2,m);
        }else {
            return (a+ modMultiplication(a,(b-1),m))%m;
        }

    }
}
