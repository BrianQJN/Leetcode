/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2023-12-29
 */
public class search_a_2D_matrix_74 {
    /**
     * @implSpec You are given an m x n integer matrix with the following two properties:
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     * You must write a solution in O(log(m * n)) time complexity.
     * @author Brian Qu
     * @param matrix an m x n integer matrix, each row is sorted in non-decreasing order, the first integer of each row is greater than the last integer of the previous row.
     * @param target the target to search.
     * @return boolean - return true if target is in matrix, else false.
     * @since 2023-12-29 18:08
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // initialization
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        // shrink the interval
        while (left <= right) {
            // calculate the mid-value
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            // compare the mid-value with target to decide the shrink direction
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
