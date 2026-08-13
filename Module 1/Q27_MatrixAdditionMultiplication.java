// Question 27: Write a Java program to perform matrix addition and multiplication.

public class Q27_MatrixAdditionMultiplication {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8, 9},
            {1, 2, 3}
        };

        System.out.println("--- Matrix Addition ---");
        int rowsA = A.length;
        int colsA = A[0].length;
        int[][] sumMatrix = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                sumMatrix[i][j] = A[i][j] + B[i][j];
            }
        }
        printMatrix(sumMatrix);

        System.out.println("\n--- Matrix Multiplication ---");
        // Matrix M (2x3) and Matrix N (3x2)
        int[][] M = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] N = {
            {7, 8},
            {9, 1},
            {2, 3}
        };

        int rowsM = M.length;
        int colsM = M[0].length;
        int colsN = N[0].length;
        int[][] prodMatrix = new int[rowsM][colsN];

        for (int i = 0; i < rowsM; i++) {
            for (int j = 0; j < colsN; j++) {
                for (int k = 0; k < colsM; k++) {
                    prodMatrix[i][j] += M[i][k] * N[k][j];
                }
            }
        }
        printMatrix(prodMatrix);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
