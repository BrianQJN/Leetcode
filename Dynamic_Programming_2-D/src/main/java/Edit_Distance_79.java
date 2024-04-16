/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-15
 */
public class Edit_Distance_79 {
    /**
     * @param word1 the string to be converted
     * @param word2 the string to convert to
     * @return int - the minimum number of
     * @implSpec Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     * You have the following three operations permitted on a word:
     * Insert a character
     * Delete a character
     * Replace a character
     * @author Brian Qu
     * @since 2024-04-15 21:46
     */
    public int minDistance(String word1, String word2) {
        // initialize DP table
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // since we need to delete i times to form empty string
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // since we need to insert j times to form string word2
        }

        // fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1]; // chars match, so we don't need to do anything at cur char
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1); // chars don't match, deletion dp[i-1][j] + 1, insertion dp[i][j-1] + 1, replacement dp[i-1][j-1] + 1.
                }
            }
        }

        return dp[m][n];
    }
}
