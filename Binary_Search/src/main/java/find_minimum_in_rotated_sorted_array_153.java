/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-30
 */
public class find_minimum_in_rotated_sorted_array_153 {
    /**
     * @implSpec Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
     * You must write an algorithm that runs in O(log n) time.
     * @author Brian Qu
     * @param nums an integer array of length n sorted in ascending order is rotated
     * @return int - the minimum element of this array
     * @since 2023-12-30 22:19
     */
    public int findMin(int[] nums) {
        // initialize left and right boundaries
        int left = 0, right = nums.length - 1;

        // shrink the boundaries
        while (left < right) {
            // calculate mid value
            int mid = left + (right - left) / 2;

            // determine the shrink direction
            if (nums[mid] > nums[right]) {
                // means the min value on the right side
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[right];
    }
}
