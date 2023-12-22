/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-22
 */
public class product_of_array_except_self_238 {
    /**
     * @implSpec Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * @author Brian Qu
     * @param nums an integer array
     * @return array
     * @since 2023-12-22 15:24
     */
    public int[] productExceptSelf(int[] nums) {
        // initialize the res array
        int[] res = new int[nums.length];

        // calculate the left product in each position
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // calculate the right product in each position
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return res;
    }
}
