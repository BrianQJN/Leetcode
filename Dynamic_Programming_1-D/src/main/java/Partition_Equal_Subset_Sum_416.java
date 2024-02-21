/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-20
 */
public class Partition_Equal_Subset_Sum_416 {
    /**
     * @param nums the original integer array
     * @return boolean - return true if we can partition the array into two subsets such that the sum of the elements are the same
     * @implSpec Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
     * @author Brian Qu
     * @since 2024-02-20 20:38
     */
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // if total sum is odd, cannot partition
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
