package contest.codechef.codeDrive;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nitin = new int[1];
        int[] sobahgya = new int[1];
        int t = sc.nextInt();
        int c, d;
        while (t-- > 0) {
            nitin[0] = sc.nextInt();
            sobahgya[0] = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            giveCoins(nitin, sobahgya, c);
            giveCoins(nitin, sobahgya, d);
            if (sobahgya[0] > nitin[0])
                System.out.println("S");
            else
                System.out.println("N");

        }

    }

    private static void giveCoins(int[] nit, int[] sob, int coins) {
        if (sob[0] > nit[0]) {
            nit[0] += coins;
        } else {
            sob[0] += coins;
        }
    }
}
