/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-21
 */
public class Maximum_Subarray_53 {
    /**
     * @param nums the original integer array
     * @return int - the largest sum of the subarray
     * @implSpec Given an integer array nums, find the subarray with the largest sum, and return its sum.
     * @author Brian Qu
     * @since 2024-02-21 00:35
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxCurrent = nums[0];
        int maxResult = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxResult = Math.max(maxResult, maxCurrent);
        }

        return maxResult;
    }
}
