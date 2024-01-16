/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-16
 */
public class Number_of_Islands_200 {
    /**
     * @param grid an m x n 2D binary grid which represents a map of land(1) and water(0)
     * @return int - the number of islands
     * @implSpec Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * @author Brian Qu
     * @since 2024-01-16 16:04
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount += dfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        // mark cur cell as visited
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

        return 1;
    }
}
