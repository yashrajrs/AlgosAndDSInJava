package practice.otherProblems;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example:

 Input: 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class NQueens {
    public int totalNQueens(int n) {
        int[] rows = new int[n];

        int[] hills = new int[4*n-1];
        int[] dales = new int[2*n-1];

        return backTrack(0,0, n, rows, hills, dales);
    }

    public boolean isUnderAttack(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row-col + 2*n] + dales[row+col];
        return (res==0) ? true: false;
    }

    public int backTrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for(int col = 0;col<n;col++) {
            if(isUnderAttack(row, col, n, rows, hills, dales)) {
                rows[col]  =1;
                hills[row-col + 2*n] = 1;
                dales[row+col] = 1;

                if(row+1 ==n ){
                    count++;
                } else {
                    count = backTrack(row+1, count, n, rows, hills, dales);
                }

                rows[col]=0;
                hills[row-col + 2*n] = 0;
                dales[row+col] = 0;
            }
        }
        return count;
    }
}

