package contest.virtual.Codeforces.edu121;

import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char[] ch = s.toCharArray();

            Arrays.sort(ch);
            StringBuilder ans = new StringBuilder();
            for (char c : ch) {
                ans.append(c);
            }

            System.out.println(ans.toString());

        }
        sc.close();
        System.exit(0);
    }
}
