package practice;

import java.util.*;

class Problem5 {

    public static void main(String[] args) {
        int[][] grid = {
            {1,0},{0,1}
        };



        System.out.println(new Solution().largestIsland(grid));
    }

     public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String ans = "";
        int max = 0;
        String b = sb.toString();
        for(int i = 0 ; i < s.length() ; i++) {
            for(int j = i+1 ; j <= s.length(); j++) {
                if(b.contains(s.substring(i,j))) {
                    System.out.println(s.substring(i,j));
                    if(s.substring(i,j).length() > max ){
                        max = s.substring(i,j).length();
                        ans = s.substring(i,j);
                    }
                }
            }
        }
        
        return ans;
        
    }
    

}

class Solution {

    public int largestIsland(int[][] grid) {
        int max_Area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int area = getArea(grid, i, j);
                //System.out.println(area);
                max_Area = Math.max(max_Area, area);
            }
        }

        return max_Area;
    }

    private static int getArea(int[][] grid, int i, int j) {

        int n = grid.length;
        boolean[][] visited = new boolean[grid.length][grid.length];

        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(i, j));
        int area = 0;

        while (!q.isEmpty()) {

            Pair p = q.remove();
            if(!visited[p.i][p.j]) {
                visited[p.i][p.j] = true;
                area++;

                Pair up = new Pair(p.i - 1, p.j);
                Pair down = new Pair(p.i + 1, p.j);
                Pair left = new Pair(p.i, p.j - 1);
                Pair right = new Pair(p.i, p.j + 1);

                // System.out.println(down.i+" "+down.j);

                if (up.isValid(n) && !visited[p.i - 1][p.j]) {
                    if (grid[p.i - 1][p.j] == 1) {
                        q.add(up);
                    }

                }
                if (down.isValid(n) && !visited[p.i + 1][p.j]) {
                    if (grid[p.i + 1][p.j] == 1) {
                        q.add(down);
                    }

                }
                if (left.isValid(n) && !visited[p.i][p.j - 1]) {
                    if (grid[p.i][p.j - 1] == 1) {
                        q.add(left);
                    }

                }
                if (right.isValid(n) && !visited[p.i][p.j + 1]) {
                    if (grid[p.i][p.j + 1] == 1) {
                        q.add(right);
                    }

                }

            }
          
        }

        return area;

    }

}

class Pair {
    int i, j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public boolean isValid(int n) {

        return (i >= 0 && i < n) && (j >= 0 && j < n);

    }

}
