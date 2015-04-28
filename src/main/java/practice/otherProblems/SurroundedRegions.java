package practice.otherProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 * A region is captured by flipping all 'O's into 'X's in that surrounded region.

 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:

 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * @author Yashraj R. Sontakke
 */
public class SurroundedRegions {
    private Queue<Integer> queue = new LinkedList<Integer>();

    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            if(board[i][0] == '0'){
                bfs(board, i, 0);
            }
            if(board[i][n-1] == '0'){
                bfs(board, i, n-1);
            }
        }

        for(int j=0; j<n;j++){
            if(board[0][j] == '0'){
                bfs(board, 0, j);
            }
            if(board[m-1][j] == '0'){
                bfs(board, m-1, j);
            }
        }

        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '0'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = '0';
                }
            }
        }


    }

    private void bfs(char[][] board, int i, int j){
        int n = board[0].length;

        fillCell(board, i, j);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int x = cur / n;
            int y = cur % n;

            fillCell(board, x-1, y);
            fillCell(board, x+1, y);
            fillCell(board, x, y-1);
            fillCell(board, x, y+1);
        }
    }

    private void fillCell(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        if(i<0 || i>=m || j<0 || j>=n || board[i][j] != '0'){
            return;
        }
        queue.offer(i*n + j);
        board[i][j] = '#';
    }

    public static void main(String[] args){
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = {{'X','X','X','X'}, {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'}, {'X', '0', 'X', 'X'}};
        s.solve(board);

        for (int i=0;i<board.length; i++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        char[][] board1 = {{'X','X','X'}, {'X', '0', 'X'},
                {'X', 'X', 'X'}};
        s.solve(board1);

        for (int i=0;i<board1.length; i++){
            for (int j=0;j<board1[0].length;j++){
                System.out.print(board1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
