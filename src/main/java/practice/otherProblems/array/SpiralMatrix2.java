package practice.otherProblems.array;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p/>
 * For example,
 * Given n = 3,
 * <p/>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class SpiralMatrix2 {

    // O(n2) time O(n) space
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        generate(matrix, 0, n - 1, 1);
        return matrix;
    }

    private void generate(int[][] matrix, int a, int b, int val) {
        if (a > b) {
            return;
        }
        if (a == b) {
            matrix[a][a] = val;
            return;
        }
        for (int j = a; j < b; j++) {
            matrix[a][j] = val++;
        }
        for (int i = a; i < b; i++) {
            matrix[i][b] = val++;
        }
        for (int j = b; j > a; j--) {
            matrix[b][j] = val++;
        }
        for (int i = b; i > a; i--) {
            matrix[i][a] = val++;
        }
        generate(matrix, a + 1, b - 1, val);

    }

    public static void main(String[] args){
        SpiralMatrix2 s= new SpiralMatrix2();
        int[][] res = s.generateMatrix(3);

        for(int i=0;i<res.length;i++){
            for(int j=0;j< res[0].length;j++){
                System.out.print(res[i][j] +" ");
            }
            System.out.println();
        }
    }
}
