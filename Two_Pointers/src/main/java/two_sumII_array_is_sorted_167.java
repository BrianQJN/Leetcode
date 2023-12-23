/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-23
 */
public class two_sumII_array_is_sorted_167 {
    /**
     * @implSpec Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     * Your solution must use only constant extra space.
     * @author Brian Qu
     * @param numbers a sorted ascending order integer array
     * @param target the sum target
     * @return array, the index of two nums add up to target
     * @since 2023-12-23 15:48
     */
    public int[] twoSum(int[] numbers, int target) {
        // initialize two pointers
        int left = 0, right = numbers.length - 1;

        // move two pointers to the center
        while (left < right) {
            // if the sum of two num greater than target, move right, if less than target, move left
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left+1, right+1};
            }
        }

        // throw exception
        throw new IllegalArgumentException("No two sum solution");
    }
}
