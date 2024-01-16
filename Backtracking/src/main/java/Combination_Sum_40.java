import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-15
 */
public class Combination_Sum_40 {
    /**
     * @implSpec Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     * Note: The solution set must not contain duplicate combinations.
     * @author Brian Qu
     * @param candidates a collection of candidate numbers
     * @param target a target number
     * @return List<List<Integer>> - unique combinations that candidate numbers sum to target
     * @since 2024-01-15 22:25
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, 0, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curCombination, int[] candidates, int start, int target, int curSum) {
        // if sum exceeds target, no need to proceed, since we have sorted in ascending way
        if (curSum > target) return;

        if (curSum == target) {
            res.add(new ArrayList<>(curCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // skip the duplicate
            if (i > start && candidates[i] == candidates[i-1]) continue;

            // add cur element
            curCombination.add(candidates[i]);
            backtrack(res, curCombination, candidates, i+1, target, curSum+candidates[i]);
            // reverse, remove cur element
            curCombination.removeLast();
        }
    }
}
