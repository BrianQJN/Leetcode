/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-29
 */
public class binary_search_704 {
    /**
     * @implSpec Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     * You must write an algorithm with O(log n) runtime complexity.
     * @author Brian Qu
     * @param nums an array of integers nums which is sorted in ascending order
     * @param target the target to search
     * @return int - if target exists, return its index, else -1
     * @since 2023-12-29 17:54
     */
    public int search(int[] nums, int target) {
        // initialize the interval
        int left = 0, right = nums.length - 1;

        // shrink the interval
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // compare the mid with target
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
