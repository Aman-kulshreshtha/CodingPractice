package DSA.Algorithms.strings;

import java.util.ArrayList;
import java.util.*;

public class KMP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

        System.out.println(kmp(s, p));

    }

    private static List<Integer> kmp(String t, String p) {
        int[] pieTable = prefixArray(p);
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        int n = t.length();
        int m = p.length();

        for (; i < n;) {

            if (t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                do {

                    int target = j - 1;
                    if (target >= 0) {
                        j = pieTable[target];
                        if (t.charAt(i) == p.charAt(j)) {
                            j++;
                            break;
                        }
                    }
                } while (j != 0);

                i++;

            }

            if (j == m) {

                j = 0;

                ans.add(i - m);
                i = i - m + 1;

            }

        }
        return ans;

    }

    private static int[] prefixArray(String pattern) {

        int n = pattern.length();

        int[] ans = new int[n];

        ans[0] = 0;
        int j = 0;

        for (int i = 1; i < n;) {

            if (pattern.charAt(j) == pattern.charAt(i)) {
                ans[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    ans[i] = 0;
                    i++;

                } else {
                    j = ans[j - 1];
                }

            }
        }

        return ans;
    }
}