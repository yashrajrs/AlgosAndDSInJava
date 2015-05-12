package practice.otherProblems.array;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p/>
 * Note: You can only move either down or right at any point in time.
 *
 * @author Yashraj R. Sontakke
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] sum = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sum[j] = grid[i][j];
                } else {
                    int rowSum = i > 0 ? sum[j] : Integer.MAX_VALUE;
                    int colSum = j > 0 ? sum[j - 1] : Integer.MAX_VALUE;
                    sum[j] = grid[i][j] + Math.min(rowSum, colSum);
                }
            }
        }
        return sum[n - 1];
    }


    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};

        System.out.println(m.minPathSum(grid));
    }
}
