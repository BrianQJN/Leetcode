/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-17
 */
public class Maximum_Product_Subarray_152 {
    /**
     * @param nums an integer array
     * @return int - the largest product of the subarray
     * @implSpec Given an integer array nums, find a subarray that has the largest product, and return the product.
     * The test cases are generated so that the answer will fit in a 32-bit integer.
     * @author Brian Qu
     * @since 2024-02-17 14:52
     */
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));

            maxProduct = tempMax;

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
