package practice.problemSolving.string;

import java.util.ArrayList;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 *
 * @author Yashraj R. Sontakke
 */
public class MatrixRowColumnReplace_1_7 {

    public void formatMatrix(int[][] matrix) {
        ArrayList<String> replaces = new ArrayList<String>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    replaces.add(String.format("%d:%d", i, j));
                }
            }
        }

        for (String replaceZero : replaces) {
            String[] index = replaceZero.split(":");
            matrixReplace(matrix, Integer.valueOf(index[0]), Integer.valueOf(index[1]));
        }
        printMatrix(matrix);
    }

    public void matrixReplace(int[][] matrix, int row, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
            matrix[i][column] = 0;
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixRowColumnReplace_1_7 s = new MatrixRowColumnReplace_1_7();
        int[][] matrix = {{0, 2, 3, 4}, {4, 6, 7, 8}, {9, 8, 7, 6}, {5, 4, 3, 0}};
        s.printMatrix(matrix);
        System.out.println();
        s.formatMatrix(matrix);
    }
}
