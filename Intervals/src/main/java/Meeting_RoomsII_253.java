import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-25
 */
public class Meeting_RoomsII_253 {
    /**
     * @param intervals an array of meeting time intervals
     * @return int - the minimum number of conference rooms required
     * @implSpec Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
     * @author Brian Qu
     * @since 2024-03-25 15:48
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // extract start and end times
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // sort the start and end times
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        // use two pointers to traverse the two times array
        int startPointer = 0, endPointer = 0, rooms = 0;
        while (startPointer < intervals.length) {
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                rooms--;
                endPointer++;
            }

            rooms++;
            startPointer++;
        }

        return rooms;
    }
}
