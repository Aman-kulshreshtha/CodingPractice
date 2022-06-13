package DSA.TopicPractice.RecursionBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class FloodFill {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        int[][] maze = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        System.out.println(flodFill(maze, 0, 0));
        sc.close();

    }

    private static ArrayList<String> flodFill(int[][] maze, int i, int j) {

        ArrayList<String> ans = new ArrayList<>();

        int m = maze.length, n = maze[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return ans;
        }

        if (maze[i][j] == 1) {
            return ans;
        }

        if (i == m - 1 && j == n - 1) {
            ans.add("");
            return ans;
        }

        maze[i][j] = 1;

        ArrayList<String> abovePaths = flodFill(maze, i - 1, j);

        ArrayList<String> leftPaths = flodFill(maze, i, j - 1);
        ArrayList<String> belowPaths = flodFill(maze, i + 1, j);
        ArrayList<String> rightPaths = flodFill(maze, i, j + 1);

        for (String path : abovePaths) {
            ans.add("t" + path);
        }
        for (String path : leftPaths) {
            ans.add("l" + path);
        }
        for (String path : belowPaths) {
            ans.add("d" + path);
        }

        for (String path : rightPaths) {
            ans.add("r" + path);
        }

        maze[i][j] = 0;
        return ans;
    }

}
