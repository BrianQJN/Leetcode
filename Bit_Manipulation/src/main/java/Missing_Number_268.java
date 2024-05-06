/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-06
 */
public class Missing_Number_268 {
    /**
     * @param nums an array nums containing n distinct numbers in the range [0, n]
     * @return int - the only number in the range that is missing from the array
     * @implSpec Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     * @author Brian Qu
     * @since 2024-05-06 19:32
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        int i = 0;

        for (; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }

        return res ^ i;
    }
}
