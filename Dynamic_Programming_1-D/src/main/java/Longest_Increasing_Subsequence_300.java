import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-17
 */
public class Longest_Increasing_Subsequence_300 {
    /**
     * @param nums the original integer array
     * @return int - the length of the longest strictly increasing subsequence
     * @implSpec Given an integer array nums, return the length of the longest strictly increasing subsequence
     * @author Brian Qu
     * @since 2024-02-17 22:21
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;

        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}