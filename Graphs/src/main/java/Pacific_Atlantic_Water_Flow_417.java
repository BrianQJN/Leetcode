import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-17
 */
public class Pacific_Atlantic_Water_Flow_417 {
    /**
     * @param heights heights[r][c] represents the height above sea level of the cell at (r,c)
     * @return List<List<Integer>> - the coordinates of cells that rain water can flow to both Pacific and Atlantic oceans
     * @implSpec There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
     * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
     * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
     * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
     * @author Brian Qu
     * @since 2024-01-17 14:04
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // apply DFS from Pacific and Atlantic edges
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, j);
        }

        // collect cell that can reach both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int edgeHeight, int x, int y) {
        int m = heights.length, n = heights[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || heights[x][y] < edgeHeight) {
            return;
        }

        visited[x][y] = true;
        dfs(heights, visited, heights[x][y], x + 1, y);
        dfs(heights, visited, heights[x][y], x - 1, y);
        dfs(heights, visited, heights[x][y], x, y + 1);
        dfs(heights, visited, heights[x][y], x, y - 1);
    }
}
