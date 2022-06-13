package practice.random;

public class graphQ1 {

    public static void main(String[] args) {
        int[][] matrix= {{0,3,4,2,5},{1,3,4,2,5},{2,3,4,8,1},{3,3,7,2,1}};
        int k = 3;
        System.out.println(isTraversable(matrix,k));
    }

    private static boolean isTraversable(int[][] matrix, int K) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return traversalUtil(matrix,K,visited,0,0);
    }

    private static boolean traversalUtil(int[][] matrix ,int K , boolean[][] visited ,int i , int j) {
        visited[i][j] = true;
        int m = matrix.length;
        int n = matrix[0].length;

        if(i== m-1 && j == n-1) return true;

        boolean ans = false;

        if(isValid(matrix,i-1,j) && !visited[i-1][j] && Math.abs(matrix[i-1][j] - matrix[i][j]) <= K) {
            ans = traversalUtil(matrix,K,visited,i-1,j);
        }

        if(isValid(matrix,i+1,j) && !visited[i+1][j] && Math.abs(matrix[i+1][j] - matrix[i][j]) <= K) {
            ans = ans || traversalUtil(matrix,K,visited,i+1,j);
        }

        if(isValid(matrix,i,j-1) && !visited[i][j-1] && Math.abs(matrix[i][j-1] - matrix[i][j]) <= K) {
            ans = ans || traversalUtil(matrix,K,visited,i,j-1);
        }


        if(isValid(matrix,i,j+1) && !visited[i][j+1] && Math.abs(matrix[i][j+1] - matrix[i][j]) <= K) {
            ans = ans || traversalUtil(matrix,K,visited,i,j+1);
        }

        return ans;
    }

    private static boolean isValid(int[][] matrix, int i, int j) {
        return (0<= i && i < matrix.length && 0<=j && j < matrix[0].length);
    }
}
