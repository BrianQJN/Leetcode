/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-25
 */
public class minimum_window_substring_76 {
    /**
     * @implSpec Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     * @author Brian Qu
     * @param s the string to find the window substring
     * @param t the original string
     * @return String - the minimum window substring
     * @since 2023-12-25 17:53
     */
    public String minWindow(String s, String t) {
        // initialize an array to record the char frequency in string t
        int[] tCount = new int[128];
        for (char c: t.toCharArray()) {
            tCount[c]++;
        }

        // initialization
        int start = 0, end = 0, minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int needCounter = t.length();

        // iterate the string
        while (end < s.length()) {
            char curChar = s.charAt(end);
            // if cur char in string t, char needed counter minus 1
            if (tCount[curChar] > 0) {
                needCounter--;
            }
            // update the char count in string t and expand window
            tCount[curChar]--;
            end++;

            // if the char needed counter is equal to 0, we can slide the window
            while (needCounter == 0) {
                // update the min length and min start position
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                // since we slide the window, the start char need to check if it is in the t string
                // if yes, add its frequency and if its frequency is greater than 0, mean we need one more char in window
                // so, char needed counter plus 1. Then slide the window.
                char startChar = s.charAt(start);
                tCount[startChar]++;
                if (tCount[startChar] > 0) {
                    needCounter++;
                }
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
