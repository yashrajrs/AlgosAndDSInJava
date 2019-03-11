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
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i=0; i< matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        for(int i=0; i< matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length ;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length ;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstColZero){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MatrixRowColumnReplace_1_7 s = new MatrixRowColumnReplace_1_7();
        int[][] matrix = {{0, 2, 3, 4}, {4, 6, 7, 8}, {9, 8, 7, 6}, {5, 4, 3, 0}};
        s.printMatrix(matrix);
        System.out.println();
        s.formatMatrix(matrix);

        int[][] matrix1 = {{0, 2, 3, 4}, {4, 6, 7, 8}, {9, 8, 7, 6}, {5, 4, 3, 0}};
        System.out.println();
        s.setZeroes(matrix1);
        s.printMatrix(matrix1);

        int[][] matrix2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        System.out.println();
        s.setZeroes(matrix2);
        s.printMatrix(matrix2);
    }
}
