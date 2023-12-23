import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-23
 */
public class longest_consecutive_sequence_128 {
    /**
     * @implSpec Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     * @author Brian Qu
     * @param nums an unsorted array of integers
     * @return int - the longest consecutive elements sequence length
     * @since 2023-12-23 14:05
     */
    public int longestConsecutive(int[] nums) {
        // initialize a HashSet to record all the elements in the array
        Set<Integer> numSet = new HashSet<>();
        // obtain all the elements
        for (int num: nums) {
            numSet.add(num);
        }

        // initialize a length to record the longest length of consecutive sequence
        int longestLength = 0;

        // traverse the HashSet
        for (int num: numSet) {
            // if the num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;

                // expand the sequence and count the length
                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    curLength += 1;
                }

                // update the longest length
                longestLength = Math.max(longestLength, curLength);
            }
        }

        return longestLength;
    }
}
