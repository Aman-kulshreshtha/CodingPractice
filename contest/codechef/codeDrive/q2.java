package contest.codechef.codeDrive;

import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int i1 = s.indexOf("chef");
            int i2 = s.indexOf("code");
            if (i2 < i1)
                System.out.println("AC");
            else
                System.out.println("WA");

        }

    }

}
