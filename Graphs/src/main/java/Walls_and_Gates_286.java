import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-19
 */
public class Walls_and_Gates_286 {
    private static final int INF = 2147483647;
    /**
     * @param rooms an m x x grid rooms with three possible values
     * @implSpec You are given an m x n grid rooms initialized with these three possible values.
     * -1 A wall or an obstacle.
     * 0 A gate.
     * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
     * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
     * @author Brian Qu
     * @since 2024-01-19 15:16
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // add gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0], col = point[1];

            // check all four directions
            for (int[] direction : directions) {
                int newRow = row + direction[0], newCol = col + direction[1];

                // check boundaries and if it's an empty room
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}
