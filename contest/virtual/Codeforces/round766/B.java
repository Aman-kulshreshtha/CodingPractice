package contest.virtual.Codeforces.round766;

import java.util.*;

public class B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            int n = sc.nextInt(), m = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    arr.add(getDist(i, j, n, m));
                }
            }
            Collections.sort(arr);
            for (int x : arr) {
                System.out.print(x + " ");

            }

            System.out.println();

        }

    }

    private static int getDist(int i, int j, int n, int m) {
        int a = Math.abs(i - n) + Math.abs(j - m);
        int b = Math.abs(i - 1) + Math.abs(j - m);
        int c = Math.abs(i - 1) + Math.abs(j - 1);
        int d = Math.abs(i - n) + Math.abs(j - 1);

        return Math.max(Math.max(a, b), Math.max(c, d));
    }

}