import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-07
 */
public class Minimum_Interval_to_Include_Each_Query_1851 {
    /**
     * @param intervals a 2D integer array intervals
     * @param queries an integer array
     * @return int[] - an array containing the answers to the queries
     * @implSpec You are given a 2D integer array intervals, where intervals[i] = [lefti, righti] describes the ith interval starting at lefti and ending at righti (inclusive). The size of an interval is defined as the number of integers it contains, or more formally righti - lefti + 1.
     * You are also given an integer array queries. The answer to the jth query is the size of the smallest interval i such that lefti <= queries[j] <= righti. If no such interval exists, the answer is -1.
     * Return an array containing the answers to the queries.
     * @author Brian Qu
     * @since 2024-04-07 14:38
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort the intervals by their start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // pair each query with its index, then sort by query value
        int[][] indexQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexQueries[i] = new int[]{queries[i], i};
        }

        // sort the indexQueries
        Arrays.sort(indexQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[queries.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int i = 0;

        for (int[] query: indexQueries) {
            // add all intervals that could contain the current query
            while (i < intervals.length && intervals[i][0] <= query[0]) {
                pq.offer(intervals[i]);
                i++;
            }

            // remove intervals that end before the current query point
            while (!pq.isEmpty() && pq.peek()[1] < query[0]) {
                pq.poll();
            }

            res[query[1]] = pq.isEmpty()? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }

        return res;
    }
}
