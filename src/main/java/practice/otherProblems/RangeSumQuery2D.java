package practice.otherProblems;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12
 Note:
 You may assume that the matrix does not change.
 There are many calls to sumRegion function.
 You may assume that row1 ≤ row2 and col1 ≤ col2.

 */
public class RangeSumQuery2D {

    int[][] sum;

    public RangeSumQuery2D(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];

        for(int i=0;i<m;i++) {
            int sumRow = 0;
            for(int j=0;j<n;j++) {
                if (i==0) {
                    sumRow += matrix[i][j];
                    sum[i][j] = sumRow;
                } else {
                    sumRow += matrix[i][j];
                    sum[i][j] = sumRow + sum[i-1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.sum == null) {
            return 0;
        }
        int topRightX = row1;
        int topRightY = col2;

        int bottomLeftX = row2;
        int bottomLeftY = col1;

        int result = 0;
        if(row1 == 0 && col1 == 0) {
            result = sum[row2][col2];
        } else if (row1 == 0) {
            result = sum[row2][col2] - sum[bottomLeftX][bottomLeftY-1];
        } else if (col1 == 0) {
            result = sum[row2][col2] - sum[topRightX-1][topRightY];
        } else {
            result = sum[row2][col2] - sum[topRightX-1][topRightY] - sum[bottomLeftX][bottomLeftY-1] + sum[row1-1][col1-1];
        }
        return result;
    }
}
