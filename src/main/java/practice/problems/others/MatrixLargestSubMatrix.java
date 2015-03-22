package practice.problems.others;

/**
 * Given an NxN matrix of positive and negative integers, write code to find the submatrix
 * with the largest possible sum
 *
 * @author Yashraj R. Sontakke
 */
public class MatrixLargestSubMatrix {

    public void getMaxMatrix(int[][] original) {
        int maxArea = Integer.MIN_VALUE;
        int rowCount = original.length;
        int colCount = original[0].length;
        int[][] matrix = preCompute(original);
        int rowStart = -1, rowEnd = -1, colStart = -1, colEnd = -1;
        for (int row1 = 0; row1 < rowCount; row1++) {
            for (int row2 = 0; row2 < rowCount; row2++) {
                for (int col1 = 0; col1 < colCount; col1++) {
                    for (int col2 = 0; col2 < colCount; col2++) {
                        int currentMatrixValue = computeSum(matrix, row1, row2, col1, col2);
                        if (maxArea < currentMatrixValue) {
                            maxArea = currentMatrixValue;
                            rowStart = row1;
                            rowEnd = row2;
                            colStart = col1;
                            colEnd = col2;
                        }
                    }
                }
            }
        }
        System.out.println(String.format("Max area = %d, rowStart = %d, rowEnd = %d, colStart = %d, colEnd = %d", maxArea, rowStart, rowEnd, colStart, colEnd));
    }

    public int[][] preCompute(int[][] matrix) {
        int[][] sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) {
                    sumMatrix[i][j] = matrix[i][j];
                } else if (i == 0) {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j - 1];
                } else if (j == 0) {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j];
                } else {
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
        return sumMatrix;
    }

    public int computeSum(int[][] subMatrix, int row1, int row2, int col1, int col2) {
        if (row1 == 0 && col1 == 0) {
            return subMatrix[row2][col2];
        } else if (row1 == 0) {
            return subMatrix[row2][col2] - subMatrix[row2][col1 - 1];
        } else if (col1 == 0) {
            return subMatrix[row2][col2] - subMatrix[row1 - 1][col2];
        } else {
            return subMatrix[row2][col2] - -subMatrix[row2][col1 - 1] - subMatrix[row1 - 1][col2] + subMatrix[row1 - 1][col1 - 1];
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}};
        MatrixLargestSubMatrix matrixLargestSubMatrix = new MatrixLargestSubMatrix();
        matrixLargestSubMatrix.getMaxMatrix(matrix);

    }
}
