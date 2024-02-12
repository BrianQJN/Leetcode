/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-11
 */
public class Decode_Ways_91 {
    /**
     * @param s the encoded message string
     * @return int - the number of ways to decode it
     * @implSpec To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
     * "AAJF" with the grouping (1 1 10 6)
     * "KJF" with the grouping (11 10 6)
     * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
     * Given a string s containing only digits, return the number of ways to decode it.
     * The test cases are generated so that the answer fits in a 32-bit integer.
     * @author Brian Qu
     * @since 2024-02-11 21:54
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1; // empty string can decode in any way
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // based on the first char

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            if (oneDigit > 0) dp[i] += dp[i-1];

            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i-2];
        }

        return dp[n];
    }
}
