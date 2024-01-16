/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-15
 */
public class Word_Search_79 {
    /**
     * @implSpec Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * @author Brian Qu
     * @param board an m x n grid of character board
     * @param word the target word string
     * @return boolean - if the word existed in the board, return true, else false
     * @since 2024-01-15 23:07
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // check if the word is found
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;

        char curChar = board[i][j];
        board[i][j] = '*'; // mark this cell as visited

        // explore all possible directions: up, down, left, right
        boolean found = backtrack(board, word, i+1, j, index+1) || backtrack(board, word, i-1, j, index+1) ||
                        backtrack(board, word, i, j+1, index+1) || backtrack(board, word, i, j-1, index+1);

        board[i][j] = curChar;
        return found;
    }
}
