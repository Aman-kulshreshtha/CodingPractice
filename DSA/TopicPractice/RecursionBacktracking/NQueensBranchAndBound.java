package DSA.TopicPractice.RecursionBacktracking;

public class NQueensBranchAndBound {

    public static void main(String[] args) {

        int[][] chess = new int[4][4];
        boolean[] lockedCol = new boolean[5];
        boolean[] lockedMainDiag = new boolean[2 * 5 - 1];
        boolean[] lockedSecDiag = new boolean[2 * 5 - 1];

        printNqueensBranchAndBound(chess, 0, lockedCol, lockedMainDiag, lockedSecDiag);

    }

    private static void printNqueensBranchAndBound(int[][] chess, int row, boolean[] lockedCol,
            boolean[] lockedMainDiag, boolean[] lockedSecDiag) {

        if (row > chess.length) {
            return;
        }

        if (row == chess.length) {
            System.out.println("Answer: ");

            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] == 0)
                        System.out.print("_\t");
                    else
                        System.out.print("Q\t");

                }
                System.out.println();
            }

            System.out.println();

        }

        for (int col = 0; col < chess[0].length; col++) {

            // place the queen in row,col if not already blocked
            if (!lockedCol[col] && !lockedMainDiag[row + col] && !lockedSecDiag[chess.length - 1 + (row - col)]) {

                chess[row][col] = 1;
                lockedCol[col] = true;
                lockedMainDiag[row + col] = true;
                lockedSecDiag[chess.length - 1 + (row - col)] = true;

                printNqueensBranchAndBound(chess, row + 1, lockedCol, lockedMainDiag, lockedSecDiag);

                chess[row][col] = 0;
                lockedCol[col] = false;
                lockedMainDiag[row + col] = false;
                lockedSecDiag[chess.length - 1 + (row - col)] = false;

            }

        }

    }

}
