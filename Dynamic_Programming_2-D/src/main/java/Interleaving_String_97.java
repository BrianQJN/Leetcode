/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-14
 */
public class Interleaving_String_97 {
    /**
     * @param s1 the string to interleaving
     * @param s2 the string to interleaving
     * @param s3 the string to be formed
     * @return boolean - if the two strings can be interleaved to form s3, return true
     * @implSpec Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     * An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
     * Note: a + b is the concatenation of strings a and b.
     * @author Brian Qu
     * @since 2024-04-14 17:09
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();

        // base case, the length is not equal
        if ((m + n) != l) return false;

        // initialization
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        for (int j = 1; j <=n; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        // update the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        // return the result
        return dp[m][n];
    }
}
