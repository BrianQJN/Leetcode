import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-15
 */
public class Nonoverlapping_Intervals_435 {
    /**
     * @param intervals an array of intervals
     * @return int - the minimum number of intervals need to be removed
     * @implSpec Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     * @author Brian Qu
     * @since 2024-03-15 18:12
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort the intervals in ascending order by their ends
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // there is an overlap
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}