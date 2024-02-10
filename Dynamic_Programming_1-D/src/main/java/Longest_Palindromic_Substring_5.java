/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-08
 */
public class Longest_Palindromic_Substring_5 {
    /**
     * @param s the target string
     * @return String - the longest palindromic substring in s
     * @implSpec Given a string s, return the longest palindromic substring in s.
     * @author Brian Qu
     * @since 2024-02-08 17:51
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // even length palindrome
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (right - left - 1);
    }
}
