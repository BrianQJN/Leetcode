import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-23
 */
public class three_sum_15 {
    /**
     * @implSpec Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     * @author Brian Qu
     * @param nums an integer array
     * @return List, three nums that add up to 0
     * @since 2023-12-23 16:52
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // initialize the result list and sort the array
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // iterate through the array nums
        for (int i = 0; i < nums.length - 2; i++) {
            // if the num is new one
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                // initialize the two pointers and sum
                int left = i + 1, right = nums.length - 1;
                int sum = -nums[i];

                // move two pointers
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        // add the cur combination to res
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // to avoid duplicate, move left and right to next number
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
