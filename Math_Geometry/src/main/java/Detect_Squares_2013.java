import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-04
 */
public class Detect_Squares_2013 {
    private final Map<Integer, Map<Integer, Integer>> countByX;

    /**
     * @implSpec You are given a stream of points on the X-Y plane. Design an algorithm that:
     * Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
     * Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
     * An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.
     * Implement the DetectSquares class:
     * DetectSquares() Initializes the object with an empty data structure.
     * void add(int[] point) Adds a new point = [x, y] to the data structure.
     * int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
     * @author Brian Qu
     * @since 2024-05-04 23:13
     */
    public Detect_Squares_2013() {
        countByX = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        countByX.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> countByY = countByX.get(x);
        countByY.put(y, countByY.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int totalCount = 0;

        if (!countByX.containsKey(px)) return 0;

        Map<Integer, Integer> sameX = countByX.get(px);
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : countByX.entrySet()) {
            int x = entry.getKey();
            if (x == px) continue;
            Map<Integer, Integer> yMap = entry.getValue();
            int sideLen = Math.abs(x - px);

            int[] ys = new int[]{py + sideLen, py - sideLen};
            for (int y : ys) {
                if (sameX.containsKey(y) && yMap.containsKey(py)) {
                    totalCount += sameX.get(y) * yMap.get(py) * yMap.getOrDefault(y, 0);
                }
            }
        }

        return totalCount;
    }
}
