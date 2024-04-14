/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-14
 */
public class Longest_Increasing_Path_in_a_Matrix_329 {
    private static final int[] DIRS = {0, 1, 0, -1, 0};

    /**
     * @param matrix an m x n integers matrix
     * @return int - the length of the longest increasing path in the matrix
     * @implSpec Given an m x n integers matrix, return the length of the longest increasing path in matrix.
     * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
     * @author Brian Qu
     * @since 2024-04-14 18:09
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) return 0;

        // initialization DP table
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxPathLength = 0;

        // update the DP table with DFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPathLength = Math.max(maxPathLength, dfs(matrix, i, j, cache));
            }
        }

        // return the result
        return maxPathLength;
    }

    /**
     * @param matrix an m x n integers matrix
     * @param i the raw coordinate
     * @param j the column coordinate
     * @param cache the dp table to store the status
     * @return int - the max length from cur position
     * @implSpec the helper function to do the DFS
     * @author Brian Qu
     * @since 2024-04-14 18:21
     */
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];

        int max = 1;
        for (int d = 0; d < 4; d++) {
            int newX = i + DIRS[d], newY = j + DIRS[d+1];

            if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length || matrix[newX][newY] <= matrix[i][j]) {
                continue;
            }

            int len = 1 + dfs(matrix, newX, newY, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;

        return max;
    }
}
