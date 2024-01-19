import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-17
 */
public class Rotting_Oranges_994 {
    /**
     * @param grid an m x n grid where each cell represents a status
     * @return int - the minimum number of minutes that must elapse until no cell has a fresh orange
     * @implSpec You are given an m x n grid where each cell can have one of three values:
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
     * @author Brian Qu
     * @since 2024-01-17 15:46
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Initialize queue with rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS to spread rot
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] d : directions) {
                    int x = rotten[0] + d[0];
                    int y = rotten[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // rotten the fresh orange
                        queue.add(new int[]{x, y});
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes - 1 : -1;
    }
}
