/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-17
 */
public class Surrounded_Regions_130 {
    /**
     * @param board an m x n matrix board contains 'X' and 'O'
     * @implSpec Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * @author Brian Qu
     * @since 2024-01-17 14:39
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;

        // mark 'O's on the boarder and the 'O's connected to them
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // flip surrounded 'O's to 'X's and revert 'N's to 'O's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        // mark as not to be flipped
        board[i][j] = 'N';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
