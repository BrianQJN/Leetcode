/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-14
 */
public class Target_Sum_494 {
    /**
     * @param nums an integer array to form the expression
     * @param target an integer to calculate for
     * @return int - the number of different expressions that you can build
     * @implSpec You are given an integer array nums and an integer target.
     * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
     * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
     * Return the number of different expressions that you can build, which evaluates to target.
     * @author Brian Qu
     * @since 2024-04-14 14:26
     */
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // if the (totalSum + target)/2 is odd, we can't partition the numbers, which can't form expressions.
        if ((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum) {
            return 0;
        }

        // initialization
        int sum = (totalSum + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1; // one way to make sum to 0

        // update the dp table backwards
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        // return the result
        return dp[sum];
    }
}
