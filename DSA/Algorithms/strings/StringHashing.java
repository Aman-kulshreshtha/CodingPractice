package DSA.Algorithms.strings;

import java.util.*;

public class StringHashing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s;

        System.out.print("Enter a string : ");
        s = sc.next();

        System.out.println(polynomialHash(s));

        sc.close();

        System.exit(0);

    }

    private static int polynomialHash(String s) {
        int hash = 0;
        int m = 1000000007;

        int p = 47, power = 1;

        for (char ch : s.toCharArray()) {

            hash += (((ch - 'a' + 1) % m) * power) % m;

            power = (power * (p)) % m;

        }

        return hash;
    }

}