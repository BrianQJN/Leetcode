/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-03
 */
public class Set_Matrix_Zeroes_73 {
    /**
     * @param matrix an m x n integer matrix
     * @implSpec Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     * You must do it in place.
     * @author Brian Qu
     * @since 2024-05-03 21:51
     */
    public void setZeroes(int[][] matrix) {
        // identify zero rows and columns
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        int m = matrix.length;
        int n = matrix[0].length;

        // update the two boolean variables
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // use the first row and column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // zero out cells based on the markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // zero out first row and column based on the two boolean variables
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
