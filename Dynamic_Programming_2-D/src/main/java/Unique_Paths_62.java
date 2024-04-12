/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-12
 */
public class Unique_Paths_62 {
    /**
     * @param m the raw number
     * @param n the column number
     * @return int - the unique paths to reach the bottom-right cell from top-left cell
     * @implSpec There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     * @author Brian Qu
     * @since 2024-04-12 12:57
     */
    public int uniquePaths(int m, int n) {
        // create the 2D dp table
        int[][] dp = new int[m][n];

        // initialization, the first raw and column are 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        // return the result
        return dp[m-1][n-1];
    }
}
