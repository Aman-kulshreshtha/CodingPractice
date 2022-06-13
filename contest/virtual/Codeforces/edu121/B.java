package contest.virtual.Codeforces.edu121;

import java.util.*;
import java.io.*;

public class B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String max = "";
            String s = sc.next();
            int n = s.length();

            boolean ans = false;
            for (int i = n - 2; i >= 0; i--) {
                int a = Integer.parseInt(s.charAt(i) + "");
                int b = Integer.parseInt(s.charAt(i + 1) + "");

                if (a + b > 9) {
                    ans = true;
                    // logic to add
                    String mid = (a + b) + "";
                    String sb = s.substring(0, i) + mid;
                    if (i + 2 < n)
                        sb += s.substring(i + 2);

                    System.out.println(sb);
                    break;

                }

            }

            if (!ans) {
                int i = 0;
                int a = Integer.parseInt(s.charAt(i) + "");
                int b = Integer.parseInt(s.charAt(i + 1) + "");

                // logic to add
                String mid = (a + b) + "";
                String sb = s.substring(0, i) + mid;
                if (i + 2 < n)
                    sb += s.substring(i + 2);

                System.out.println(sb);

            }

        }

        sc.close();
        System.exit(0);
    }
}
