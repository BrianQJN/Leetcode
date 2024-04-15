/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-14
 */
public class Distinct_Subsequences_115 {
    /**
     * @param s the original string
     * @param t the string to compare
     * @return int - the number of distinct subsequences of s which equals t.
     * @implSpec Given two strings s and t, return the number of distinct subsequences of s which equals t.
     * The test cases are generated so that the answer fits on a 32-bit signed integer.
     * @author Brian Qu
     * @since 2024-04-14 19:57
     */
    public int numDistinct(String s, String t) {
        // initialization
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        // fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // return the result
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        Distinct_Subsequences_115 test = new Distinct_Subsequences_115();
        test.numDistinct(s, t);
    }
}
