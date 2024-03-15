import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-15
 */
public class Insert_Intervals_57 {
    /**
     * @param intervals an array of non-overlapping intervals
     * @param newInterval the interval to be inserted
     * @return int[][] - the inserted intervals
     * @implSpec You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     * Return intervals after the insertion.
     * Note that you don't need to modify intervals in-place. You can make a new array and return it.
     * @author Brian Qu
     * @since 2024-03-15 16:29
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int i = 0;
        // add all intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // updating the newInterval to the merged interval
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // add the merged interval
        res.add(newInterval);

        // add the remaining intervals
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
