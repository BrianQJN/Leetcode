/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-25
 */
public class longest_repeating_character_replacement_424 {
    /**
     * @implSpec You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     * @author Brian Qu
     * @param s the string to do the replacement
     * @param k the maximum time of replacement
     * @return int - the length of the longest substring containing the same letter
     * @since 2023-12-25 14:54
     */
    public int characterReplacement(String s, int k) {
        // initialize the sliding window and the array to record the char frequency
        int[] count = new int[26];
        int start = 0, end = 0, maxCount = 0, maxLength = 0;

        // iterate through the string
        while (end < s.length()) {
            // update maxCount
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            // shrink the window while the k times operation can't achieve goal
            // reason why don't update maxCount here is because we want the max length, and the decrease of maxCount would
            // let the window shrink, so we just need to update the maxCount when the window is expanding
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}
