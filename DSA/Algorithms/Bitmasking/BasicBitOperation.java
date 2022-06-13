package DSA.Algorithms.Bitmasking;

public class BasicBitOperation {

    public static void main(String[] args) {
        int N = 76;
        int n = 3;

        System.out.println("N in Binary is : "+ Integer.toBinaryString(N));
//
//        //set nth bit
//        N |= 1 << (n-1);
//        System.out.println(Integer.toBinaryString(N));
//
//        //clear nth bit
//        N &= ~(1<<(n-1));
//        System.out.println(Integer.toBinaryString(N));
//
//        //toggling a bit
//        N ^= (1<<(n-1));
//        System.out.println(Integer.toBinaryString(N));
//
//        //check the bit
//        int bit = (N>>(n-1))&1;
//        System.out.println(bit);


//        find right most set bit mask

        int rightMostSetBitMask = (-N) & (N);
        System.out.print(Integer.toBinaryString(rightMostSetBitMask));

    }
}
