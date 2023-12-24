import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-24
 */
public class longest_substring_without_repeating_characters_3 {
    /**
     * @implSpec Given a string s, find the length of the longest substring without repeating characters.
     * @author Brian Qu
     * @param s the string to find the longest substring without repeating characters
     * @return int - the length of the longest substring without repeating characters
     * @since 2023-12-24 17:36
     */
    public int lengthOfLongestSubstring(String s) {
        // initialize the sliding window and a HashSet to record the unique substring
        int left = 0, right = 0;
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;

        // move the sliding window
        while (right < s.length()) {
            char curChar = s.charAt(right);

            // if cur char in the HashSet, move the left until it doesn't exist
            while (seen.contains(curChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            // add the new char to the HashSet and update the maxLength
            seen.add(curChar);
            maxLength = Math.max(maxLength, seen.size());
            right++;
        }

        return maxLength;
    }
}
