/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-03
 */
public class search_in_rotated_sorted_array_33 {
    /**
     * @implSpec There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     * You must write an algorithm with O(log n) runtime complexity.
     * @author Brian Qu
     * @param nums an integer array nums sorted in ascending order (with distinct values).
     * @param target an integer to search in the array.
     * @return int - the index of target.
     * @since 2024-01-03 15:50
     */
    public int search(int[] nums, int target) {
        // initialize the boundaries
        int left = 0, right = nums.length - 1;

        // shrink the search range
        while (left <= right) {
            // calculate mid value
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];

            // compare the midValue with target
            if (midValue == target){
                return mid;
            }

            // check which side is sorted
            if (nums[left] <= nums[mid]) {
                // if the left part is sorted well, we check if the target is on the left or right
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if the right part is sorted well, we check if the target is on the left or right
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
