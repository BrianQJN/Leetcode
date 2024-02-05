/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-03
 */
public class Min_Cost_Climbing_Stairs_746 {
    /**
     * @param cost an integer array where cost[i] is the cost of ith step on a staircase.
     * @return int - the minimum cost to reach the top of the floor.
     * @implSpec You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
     * You can either start from the step with index 0, or the step with index 1.
     * Return the minimum cost to reach the top of the floor.
     * @author Brian Qu
     * @since 2024-02-03 21:59
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Base case
        if (n <= 2) {
            return Math.min(cost[0], cost[1]);
        }

        // initialize a dp array, represent the minimum cost to reach this stair
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min((dp[i-1] + cost[i-1]), (dp[i-2] + cost[i-2]));
        }

        return dp[n];
    }
}