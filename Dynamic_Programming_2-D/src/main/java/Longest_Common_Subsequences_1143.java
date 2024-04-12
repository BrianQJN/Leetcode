/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-12
 */
public class Longest_Common_Subsequences_1143 {
    /**
     * @param text1 a string to find LCS
     * @param text2 a string to find LCS
     * @return int - the length of the LCS
     * @implSpec Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     * For example, "ace" is a subsequence of "abcde".
     * A common subsequence of two strings is a subsequence that is common to both strings.
     * @author Brian Qu
     * @since 2024-04-12 14:57
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // initialize the DP table
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0;
        }

        // filling the DP table
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // return the result
        return dp[m][n];
    }
}
