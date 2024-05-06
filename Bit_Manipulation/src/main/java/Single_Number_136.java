/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-05
 */
public class Single_Number_136 {
    /**
     * @param nums a non-empty array of integers nums
     * @return int - the element appears exactly once
     * @implSpec Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * @author Brian Qu
     * @since 2024-05-05 11:42
     */
    public int singleNumber(int[] nums) {
        int single = 0;

        for (int num : nums) {
            single ^= num;
        }

        return single;
    }
}
