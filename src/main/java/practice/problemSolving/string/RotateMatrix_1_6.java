package practice.problemSolving.string;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * @author Yashraj R. Sontakke
 */
public class RotateMatrix_1_6 {

    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    public void rotate(int[][] matrix) {
        for(int layer=0; layer<matrix.length/2; ++layer){
            int first = layer;
            int last = matrix.length-1-layer;

            for(int i=first; i<last; i++){
                int offset = i-first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    public void rotate1(int[][] matrix, int n) {
        int colLength = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < colLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < colLength; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[colLength - 1 - j][i];
                matrix[colLength - 1 - j][i] = temp;
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateMatrix_1_6 rotateMatrix = new RotateMatrix_1_6();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix.printMatrix(matrix);
//        rotateMatrix.rotate(matrix, matrix.length);
        rotateMatrix.rotate(matrix);
        rotateMatrix.printMatrix(matrix);

    }
}
