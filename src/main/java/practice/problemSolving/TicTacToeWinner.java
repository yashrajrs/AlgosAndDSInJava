package practice.problemSolving;

/**
 * Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 *
 * @author Yashraj R. Sontakke
 */
public class TicTacToeWinner {

    public Integer hasWon(Integer[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }

            if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }

        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return null;
    }


    public Integer hasWon1(Integer[][] board) {
        int row = 0;
        int col = 0;
        for (row = 0; row < board.length; row++) {
            if (board[row][0] != null) {
                for (col = 1; col < board.length; col++) {
                    if (board[row][col] != board[row][col - 1]) {
                        break;
                    }
                }
            }
            if (col == board.length) {
                return board[row][0];
            }
        }

        for (col = 0; col < board.length; col++) {
            if (board[0][col] != null) {
                for (row = 1; row < board.length; row++) {
                    if (board[row][col] != board[row - 1][col]) {
                        break;
                    }
                }
                if (row == board.length) {
                    return board[0][col];
                }
            }
        }

        if (board[0][0]!=null){
            for (row=1;row<board.length;row++){
                if (board[row][row] != board[row-1][row-1]){
                    break;
                }
            }
            if (row==board.length){
                return board[0][0];
            }
        }
        if (board[board.length-1][0] !=null){
            for (row=1;row<board.length;row++){
                if(board[board.length-row-1][row] !=board[board.length-row][row-1]){
                    break;
                }
            }
            if (row==board.length){
                return board[board.length-1][0];
            }
        }
        return null;
    }

    public static void s(String[] args) {
        TicTacToeWinner ticTacToeWinner = new TicTacToeWinner();
        Integer[][] board = {{0, 0, 0}, {1, 0, 1}, {1, 0, 1}};
        Integer winner = ticTacToeWinner.hasWon(board);
        if (winner != null) {
            System.out.println("Winner is " + winner);
        } else {
            System.out.println("No winner");
        }

        Integer winner2 = ticTacToeWinner.hasWon1(board);
        if (winner2 != null) {
            System.out.println("Winner is " + winner2);
        } else {
            System.out.println("No winner");
        }
    }

}
