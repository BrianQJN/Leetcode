import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-03
 */
public class Spiral_Matrix_54 {
    /**
     * @param matrix an m x n matrix
     * @return List<Integer> - all elements of the matrix in spiral order
     * @implSpec Given an m x n matrix, return all elements of the matrix in spiral order.
     * @author Brian Qu
     * @since 2024-05-03 19:17
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        // define boundaries
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        // traverse the spiral
        while (top <= bottom && left <= right) {
            // traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        // return the result
        return res;
    }
}
