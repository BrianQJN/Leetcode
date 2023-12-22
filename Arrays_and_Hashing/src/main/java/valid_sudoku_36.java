import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-22
 */
public class valid_sudoku_36 {
    /**
     * @implSpec Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * @author Brian Qu
     * @param board a 9 x 9 Sudoku board
     * @return boolean, if the Sudoku board is valid, return true else false
     * @since 2023-12-22 16:36
     */
    public boolean isValidSudoku(char[][] board) {
        // Initialize a HashSet to record the appearance
        Set<String> seen = new HashSet<>();

        // Traverse the board
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // check if the num already existed in row, column or block, if so, return false
                    if (!seen.add(num + " in row " + i) || !seen.add(num + " in column " + j) || !seen.add(num +
                            " in block " + i/3 + '-' + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
