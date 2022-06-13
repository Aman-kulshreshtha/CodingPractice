package DSA.TopicPractice.RecursionBacktracking;

public class NQueens {

    public static void main(String[] args) {
        int[][] chess = new int[4][4];
        printNQueens(chess, "", 0);
    }

    private static void printNQueens(int[][] chess, String qsf, int row) {

        if (row == chess.length) {
            System.out.println(qsf.substring(0, qsf.length() - 1));
            return;
        }

        for (int col = 0; col < chess.length; col++) {

            if (isSafe(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }

        }

    }

    private static boolean isSafe(int[][] chess, int row, int col) {

        for (int r = row - 1; r >= 0; r--) {
            if (chess[r][col] == 1) {
                return false;
            }
        }
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (chess[r][c] == 1) {
                return false;
            }
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < chess[0].length; r--, c++) {
            if (chess[r][c] == 1) {
                return false;
            }
        }
        return true;
    }

}
