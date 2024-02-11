/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-10
 */
public class Palindromic_Substrings_647 {
    /**
     * @param s the target string
     * @return int - the number of palindromic substrings
     * @implSpec Given a string s, return the number of palindromic substrings in it.
     * A string is a palindrome when it reads the same backward as forward.
     * A substring is a contiguous sequence of characters within the string.
     * @author Brian Qu
     * @since 2024-02-10 17:04
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            count = expandAroundCenter(s, i, i, count);
            count = expandAroundCenter(s, i, i+1, count);
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right, int count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }
}
