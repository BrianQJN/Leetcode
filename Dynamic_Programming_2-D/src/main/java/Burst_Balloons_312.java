/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-23
 */
public class Burst_Balloons_312 {
    /**
     * @param nums an array represents the numbers painted on each balloon.
     * @return int - the max coins you can collect by bursting all the balloons.
     * @implSpec You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
     * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it
     * Return the maximum coins you can collect by bursting the balloons wisely.
     * @author Brian Qu
     * @since 2024-04-23 23:32
     */
    public int maxCoins(int[] nums) {
        // define the DP array
        int n = nums.length;
        int[] newNums = new int[n + 2]; // extend the nums with 1 on both ends
        newNums[0] = newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        int[][] dp = new int[n + 2][n + 2];

        // fill the DP table
        for (int len = 2; len < n + 2; len++) {
            for (int i = 0; i < n + 2 - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    int gain = newNums[i] * newNums[k] * newNums[j];
                    int total = gain + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], total);
                }
            }
        }

        return dp[0][n+1];
    }
}
