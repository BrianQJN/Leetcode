import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-14
 */
public class Subsets_78 {
    /**
     * @implSpec Given an integer array nums of unique elements, return all possible subsets(the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * @author Brian Qu
     * @param nums an integer array of unique elements
     * @return List<List<Integer>> - all possible subsets
     * @since 2024-01-14 15:07
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), output);
        return output;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> output) {
        // add the current subset to output
        output.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // include the number in the subset
            current.add(nums[i]);
            backtrack(i+1, nums, current, output);
            // exclude the number from the subset
            current.removeLast();
        }
    }
}
