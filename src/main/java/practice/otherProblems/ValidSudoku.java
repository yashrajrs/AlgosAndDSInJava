package practice.otherProblems;

import java.util.ArrayList;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * @author Yashraj R. Sontakke
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }
        ArrayList<boolean[]> rowChecker = new ArrayList<boolean[]>();
        ArrayList<boolean[]> columnChecker = new ArrayList<boolean[]>();
        ArrayList<boolean[]> blockChecker = new ArrayList<boolean[]>();

        for(int i=0;i<9;i++){
            rowChecker.add(new boolean[9]);
            columnChecker.add(new boolean[9]);
            blockChecker.add(new boolean[9]);
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }

                int c = board[i][j] - '1';
                if(rowChecker.get(j)[c] == true || columnChecker.get(i)[c] == true || blockChecker.get(i/3*3+j/3)[c] == true){
                    return false;
                }else{
                    rowChecker.get(j)[c] = true;
                    columnChecker.get(i)[c] = true;
                    blockChecker.get(i/3*3+j/3)[c] = true;
                }
            }
        }
        return true;
    }
}
