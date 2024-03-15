import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-15
 */
public class Merge_Intervals_56 {
    /**
     * @param intervals an array of intervals
     * @return int[][] - the non-overlapping intervals
     * @implSpec Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * @author Brian Qu
     * @since 2024-03-15 17:46
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // sort the intervals in ascending order by their starts before merge
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // there is overlap, so we need to merge the current and previous interval
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
