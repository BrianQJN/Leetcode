import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-13
 */
public class K_Closest_Points_to_Origin_973 {
    /**
     * @implSpec Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     * @author Brian Qu
     * @param points an array of point's coordinates
     * @param k the number of closest points needed
     * @return int[][] - the coordinates of the k closest points
     * @since 2024-01-13 14:37
     */
    public int[][] kClosest(int[][] points, int k) {
        // initialize a maxHeap and res
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
            }
        });

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
