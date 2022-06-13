package DSA.Algorithms.Bitmasking;

import java.util.Scanner;

public class KernighansAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(N+ " has "+ countSetBits(N) + " ones in binary representation :" + Integer.toBinaryString(N));
    }

    private static int rsbm(int N) {
        return (-N)&N;
    }

    private static int countSetBits(int N) {
        int mask = rsbm(N);
        int count = 0;
        while(mask!= 0) {
            count++;
            N -= mask;
            mask = rsbm(N);
        }

        return count;
    }
}
