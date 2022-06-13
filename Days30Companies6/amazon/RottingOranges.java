package Days30Companies6.amazon;

import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] oranges = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 },
        };

        System.out.println(orangesRotting(oranges));

    }

    public static int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] copy = new int[m][n];

        // creating a copy of the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                copy[i][j] = grid[i][j];

            }
        }

        boolean newAddition = true;
        int time = 0;

        for (time = -1; newAddition; time++) {

            newAddition = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (doRotting(grid, copy, i, j) > 0)
                        newAddition = true;

                }
            }

            // copy back to grid
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    grid[i][j] = copy[i][j];

                }
            }

        }

        return time;

    }

    private static int doRotting(int[][] grid, int[][] copy, int i, int j) {

        if (grid[i][j] != 2)
            return 0;

        // System.out.println("rotting at " + i + " " + j);
        int count = 0;

        if (isValid(grid, i - 1, j) && grid[i - 1][j] == 1) {
            copy[i - 1][j] = 2;
            count++;
        }

        if (isValid(grid, i + 1, j) && grid[i + 1][j] == 1) {
            copy[i + 1][j] = 2;
            count++;
        }

        if (isValid(grid, i, j - 1) && grid[i][j - 1] == 1) {
            copy[i][j - 1] = 2;
            count++;
        }

        if (isValid(grid, i, j + 1) && grid[i][j + 1] == 1) {
            copy[i][j + 1] = 2;
            count++;
        }

        return count;

    }

    private static boolean isValid(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        return ((0 <= i && i < m) && (0 <= j && j < n));
    }

}