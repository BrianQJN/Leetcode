/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-24
 */
public class Regular_Expression_Matching_10 {
    /**
     * @param s the string to be match
     * @param p the string includes regular expressions to match string s
     * @return boolean - return true if the regular expressions match the original string
     * @implSpec Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * @author Brian Qu
     * @since 2024-04-24 12:40
     */
    public boolean isMatch(String s, String p) {
        // define the DP array
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        // initialization
        dp[0][0] = true;
        for (int j = 2; j < n + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        // fill the DP table
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);

                if (curS == curP || curP == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (curP == '*') {
                    char prevP = p.charAt(j - 2);

                    if (prevP == curS || prevP == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j]; // dp[i-1][j] means there is a match, and we don't need to consider s[i-1], so we move from dp[i][j] to dp[i-1][j]
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
