import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-14
 */
public class Combination_Sum_39 {
    /**
     * @implSpec Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     * @author Brian Qu
     * @param candidates an array of distinct integers
     * @param target a target integer
     * @return List<List<Integer>> - all unique combinations that sum up to target
     * @since 2024-01-14 16:26
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> res, int currentSum) {
        if (currentSum == target) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target, i, current, res, currentSum + candidates[i]);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Combination_Sum_39 test = new Combination_Sum_39();
        System.out.println(test.combinationSum(candidates, target));
    }
}
