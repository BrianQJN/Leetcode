import java.util.HashMap;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-21
 */
public class two_sum_1 {
    /**
     * @implSpec Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * @author Brian Qu
     * @param nums an array of integers
     * @param target the target sum
     * @return int[] the indices of two numbers in nums add up to target
     * @since 2023-12-21 23:23
     */
    public int[] twoSum(int[] nums, int target) {
        // initialize a HashMap to record the number and its index
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // iterate through the given array nums
        for (int i = 0; i < nums.length ; i++) {
            int difference = target - nums[i];
            // if difference is in the map, we found the two numbers, else add the num and index to the map
            if (numMap.containsKey(difference)) {
                return new int[] {numMap.get(difference), i};
            }
            numMap.put(nums[i], i);
        }

        // throw exception
        throw new IllegalArgumentException("No two sum solution");
    }
}
