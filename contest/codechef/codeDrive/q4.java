package contest.codechef.codeDrive;

import java.util.*;

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ans = new int[k];
            String s = sc.next();

            int i = 0, j = 0;
            while (i + k <= n) {
                j = i;
                for (; j < i + k; j++) {

                    if (s.charAt(j) == '1')
                        ans[j - i]++;
                }
                i++;
            }
            int a = 0;
            for (i = 0; i < k; i++) {
                a += ans[i] % 2;
            }

            System.out.println(a);

        }
    }
}
