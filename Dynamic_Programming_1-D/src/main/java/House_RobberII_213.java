import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-06
 */
public class House_RobberII_213 {
    /**
     * @param nums the money can rob in each house
     * @return int - the maximum money can rob in one night
     * @implSpec You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     * @author Brian Qu
     * @since 2024-02-06 22:37
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robLinear(Arrays.copyOfRange(nums, 0, nums.length-1)), robLinear(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robLinear(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length-1];
    }
}
