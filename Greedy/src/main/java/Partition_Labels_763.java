import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-14
 */
public class Partition_Labels_763 {
    /**
     * @param s the original string to be partitioned
     * @return list - a list of integers representing the size of these parts.
     * @implSpec You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
     * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
     * Return a list of integers representing the size of these parts.
     * @author Brian Qu
     * @since 2024-03-14 17:27
     */
    public List<Integer> partitionLabels(String s) {
        // record the last occurrence of each letter
        int[] lastOccur = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // update end to the furthest last occurrence of cur letter
            end = Math.max(end, lastOccur[s.charAt(i) - 'a']);

            // if the current position is the end of the partition
            // record the partition size and start next partition
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
