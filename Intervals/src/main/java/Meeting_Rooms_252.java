import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-25
 */
public class Meeting_Rooms_252 {
    /**
     * @param intervals an array of meeting time intervals
     * @return boolean - if a person can take all meetings, return True
     * @implSpec Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
     * @author Brian Qu
     * @since 2024-03-25 15:36
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }

        // sort the intervals based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // check for the overlaps
        for (int i = 0; i < intervals.length - 1; i++) {
            // if there has overlaps
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}
