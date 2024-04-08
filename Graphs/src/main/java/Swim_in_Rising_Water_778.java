/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-08
 */
public class Swim_in_Rising_Water_778 {
    private static final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    /**
     * @param grid an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point
     * @return int - the least time until you can reach the bottom right square
     * @implSpec You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
     * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
     * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
     * @author Brian Qu
     * @since 2024-04-08 16:40
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1;

        // do the binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][n];
            if (canSwim(grid, visited, 0, 0, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSwim(int[][] grid, boolean[][] visited, int x, int y, int t) {
        int n = grid.length;
        if (x == n - 1 && y == n - 1) return true;
        visited[x][y] = true;
        for (int[] dir : directions) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] <= t) {
                if (canSwim(grid, visited, newX, newY, t)) {
                    return true;
                }
            }
        }
        return false;
    }
}
