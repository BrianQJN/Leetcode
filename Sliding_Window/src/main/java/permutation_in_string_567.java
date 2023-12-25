/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-25
 */
public class permutation_in_string_567 {
    /**
     * @implSpec Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
     * In other words, return true if one of s1's permutations is the substring of s2.
     * @author Brian Qu
     * @param s1 the original string to provide permutations
     * @param s2 the string to compare with s1
     * @return boolean - return true if one of s1's permutations is the substring of s2
     * @since 2023-12-25 16:13
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // initialize two array to record the char frequency in each string
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // count frequency of each char in s1 and the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // check the rest of the windows in s2
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches(s1Count, s2Count)) {
                return true;
            }

            // slide the window
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
        }

        return matches(s1Count, s2Count);
    }

    /**
     * @implSpec Helper function to compare frequency counts
     * @author Brian Qu
     * @param s1Count char frequency in s1
     * @param s2Count char frequency in window in s2
     * @return boolean - return true if they have the same frequency
     * @since 2023-12-25 16:35
     */
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }

        return true;
    }
}
