/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-16
 */
public class Max_Area_of_Island_695 {
    /**
     * @param grid an m x n binary matrix grid
     * @return int - the maximum area of an island in the grid
     * @implSpec You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     * The area of an island is the number of cells with a value 1 of the island.
     * Return the maximum area of an island in grid. If there is no island, return 0.
     * @author Brian Qu
     * @since 2024-01-16 17:38
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        // boundary condition
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // mark cur cell as visited
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i, j - 1);
        area += dfs(grid, i, j + 1);

        return area;
    }
}
