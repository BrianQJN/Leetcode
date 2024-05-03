/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-03
 */
public class Rotate_Image_48 {
    /**
     * @param matrix an n x n 2D matrix representing an image
     * @implSpec You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     * @author Brian Qu
     * @since 2024-05-03 16:30
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for (int[] row : matrix) {
            reverseRow(row);
        }
    }

    private void reverseRow(int[] row) {
        int start = 0, end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}
