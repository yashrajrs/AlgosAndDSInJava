package practice.otherProblems.array;

/**
 * Follow up for "Unique Paths":
 * <p/>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p/>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p/>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p/>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p/>
 * Note: m and n will be at most 100.
 *
 * @author Yashraj R. Sontakke
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            table[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            table[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
                }
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths2 u = new UniquePaths2();

        int[][] input = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(u.uniquePathsWithObstacles(input));

        int[][] input1 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        System.out.println(u.uniquePathsWithObstacles(input1));
    }
}
