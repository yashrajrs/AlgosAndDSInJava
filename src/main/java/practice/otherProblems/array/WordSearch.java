package practice.otherProblems.array;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean result = false;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(dfs(board, word, i, j, 0)) {
                    result =  true;
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;

        if (i<0 || i >=m || j<0 || j>=n ) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() -1) {
                return true;
            } else if (dfs(board,word, i-1, j, k+1) ||
                    dfs(board,word, i+1, j, k+1) ||
                    dfs(board,word, i, j-1, k+1) ||
                    dfs(board,word, i, j+1, k+1)
                    ){
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
                };
        char[][] board1 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board1, "SEE"));
        System.out.println(wordSearch.exist(board2, "ABCB"));
    }
}
