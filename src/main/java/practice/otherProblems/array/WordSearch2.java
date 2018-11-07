package practice.otherProblems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 Example:

 Input:
 words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Output: ["eat","oath"]
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> result = new ArrayList<String>();

        int m = board.length;
        int n = board[0].length;

        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char[][] newBoard = new char[m][n];
                    for (int x = 0; x < m; x++)
                        for (int y = 0; y < n; y++)
                            newBoard[x][y] = board[x][y];

                    if (dfs(newBoard, word, i, j, 0)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                result.add(word);
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
        WordSearch2 wordSearch = new WordSearch2();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words ={"oath","pea","eat","rain"};

        System.out.println(wordSearch.findWords(board, words));
    }
}
