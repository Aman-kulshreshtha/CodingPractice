package StriverDSASheet.day2;

public class RotateMatrix {
    private static void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = i+1 ; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0,j = n-1; i < j ; i++,j-- ) {
            for(int k = 0 ; k < n ; k++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }
    }
}
