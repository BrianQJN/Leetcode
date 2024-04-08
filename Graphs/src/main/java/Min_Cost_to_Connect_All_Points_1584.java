import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-08
 */
public class Min_Cost_to_Connect_All_Points_1584 {
    /**
     * @param points an array represents integer coordinates of some points
     * @return int - the minimum cost to make all points connected
     * @implSpec You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
     * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
     * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
     * @author Brian Qu
     * @since 2024-04-08 12:46
     */
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 0) return 0;

        // total cost to connect all points
        int totalCost = 0;
        // points included in the MST
        boolean[] inMST = new boolean[points.length];
        // min heap to store edges based on their cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // start with the first point, hence adding all its edges to the queue
        pq.offer(new int[]{0, 0}); // {cost, pointIndex}

        int edgesAdded = 0;
        while (edgesAdded < points.length) {
            int[] edge = pq.poll();
            int cost = edge[0];
            int nextPointIndex = edge[1];

            // skip if the point is already in MST
            if (inMST[nextPointIndex]) continue;

            // add the edge to the MST
            inMST[nextPointIndex] = true;
            totalCost += cost;
            edgesAdded++;

            // update the pq with edges from the new point to all other points
            for (int i = 0; i < points.length; i++) {
                if (!inMST[i]) {
                    int newCost = manhattanDistance(points[nextPointIndex], points[i]);
                    pq.offer(new int[]{newCost, i});
                }
            }
        }

        return totalCost;
    }

    private int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        Min_Cost_to_Connect_All_Points_1584 test = new Min_Cost_to_Connect_All_Points_1584();
        System.out.println(test.minCostConnectPoints(points));
    }
}
