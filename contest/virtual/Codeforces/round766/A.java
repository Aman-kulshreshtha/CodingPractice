package contest.virtual.Codeforces.round766;

import java.util.*;

public class A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt() - 1, c = sc.nextInt() - 1;
            char[][] grid = new char[n][m];
            boolean isBlack = false;
            for (int i = 0; i < n; i++) {
                String row = sc.next();
                for (int j = 0; j < row.length(); j++) {
                    grid[i][j] = row.charAt(j);
                    if (grid[i][j] == 'B') {
                        isBlack = true;
                    }
                }
            }

            if (!isBlack)
                System.out.println("-1");
            else {

                if (grid[r][c] == 'B') {
                    System.out.println("0");

                } else {
                    boolean inLineBlack = false;
                    for (int k = 0; k < m; k++) {
                        if (grid[r][k] == 'B') {
                            inLineBlack = true;
                        }
                    }

                    for (int k = 0; k < n; k++) {
                        if (grid[k][c] == 'B') {
                            inLineBlack = true;
                        }
                    }

                    if (inLineBlack) {
                        System.out.println("1");

                    } else {
                        System.out.println("2");
                    }
                }

            }

        }
        sc.close();
        System.exit(0);

    }

}