import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-15
 */
public class SubsetsII_90 {
    /**
     * @implSpec Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * @author Brian Qu
     * @param nums an integer array that may contain duplicates
     * @return List<List<Integer>> - all possible subsets excluding duplicates
     * @since 2024-01-15 20:48
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sort the given array to bring duplicates together
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curSubset, int[] nums, int start) {
        res.add(new ArrayList<>(curSubset));

        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;
            // select cur element
            curSubset.add(nums[i]);
            backtrack(res, curSubset, nums, i+1);
            // reverse the select, skip cur element
            curSubset.removeLast();
        }
    }
}
