import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-14
 */
public class Permutations_46 {
    /**
     * @implSpec Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     * @author Brian Qu
     * @param nums an array of distinct integers
     * @return List<List<Integer>> - all the possible permutations.
     * @since 2024-01-14 18:01
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> curPermutation = new ArrayList<>();
            for (int num : nums) {
                curPermutation.add(num);
            }
            res.add(curPermutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // put each number at the current index
            swap(nums, index, i);
            // recurse for the next index
            backtrack(nums, index + 1, res);
            // reverse the swap
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations_46 test = new Permutations_46();
        test.permute(nums);
    }
}
