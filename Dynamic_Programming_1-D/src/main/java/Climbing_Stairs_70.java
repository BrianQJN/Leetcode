/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-02
 */
public class Climbing_Stairs_70 {
    /**
     * @param n the number of steps to reach the top
     * @return int - the distinct ways to climb the top
     * @implSpec You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * @author Brian Qu
     * @since 2024-02-02 14:41
     */
    public int climbStairs(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }

        // DP array to store the number of ways to reach each step
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
