package practice.random;

public class UnitAreaOfLargest1 {
    private static  int findMaxArea(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i <n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = findArea(grid,visited,i,j);
                ans = Math.max(ans,temp);
            }
        }

        return ans;

    }

    private static int findArea(int[][] grid, boolean[][] visited, int i, int j) {

        int[] count = new int[1];
        if(!visited[i][j]) {
            getCount(grid, visited, i, j, count);
        }
        return count[0];

    }

    private static void getCount(int[][] grid,boolean[][] visited, int i , int j , int[] count ) {
        count[0]++;

        visited[i][j] = true;

        if(isValid(grid,i-1,j) && !visited[i-1][j]  ) {
            getCount(grid,visited,i-1,j,count);
        }

        if(isValid(grid,i+1,j) && !visited[i+1][j]  ) {
            getCount(grid,visited,i+1,j,count);
        }

        if(isValid(grid,i,j-1) && !visited[i][j-1] ) {
            getCount(grid,visited,i,j-1,count);
        }

        if(isValid(grid,i,j+1) && !visited[i][j+1] ) {
            getCount(grid,visited,i,j+1,count);
        }

        if(isValid(grid,i+1,j+1) && !visited[i+1][j+1]  ) {
            getCount(grid,visited,i+1,j+1,count);
        }

        if(isValid(grid,i+1,j-1) && !visited[i+1][j-1] ) {
            getCount(grid,visited,i+1,j-1,count);
        }

        if(isValid(grid,i-1,j-1) && !visited[i-1][j-1] ) {
            getCount(grid,visited,i-1,j-1,count);
        }

        if(isValid(grid,i-1,j+1) && !visited[i-1][j+1]) {
            getCount(grid,visited,i-1,j+1,count);
        }
    }

    private static boolean isValid(int[][] grid,int i , int j) {
        int n = grid.length;
        int m = grid[0].length;
        return (0<= i && i < n ) && (0 <= j && j < m);
    }
}
