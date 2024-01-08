/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-07
 */
public class find_the_duplicate_number_287 {
    /**
     * @implSpec Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     * There is only one repeated number in nums, return this repeated number.
     * You must solve the problem without modifying the array nums and uses only constant extra space.
     * @author Brian Qu
     * @param nums an array of integers contains n+1 integers in the range [1, n]
     * @return int - the duplicate number
     * @since 2024-01-07 19:19
     */
    public int findDuplicate(int[] nums) {
        // find the intersection point of the two pointers
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        // find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
