import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-27
 */
public class generate_parentheses_22 {
    /**
     * @implSpec Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * @author Brian Qu
     * @param n the number of pairs of parentheses
     * @return List - all combinations of well-formed parentheses
     * @since 2023-12-27 18:41
     */
    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * @implSpec backtrack to explore different paths
     * @author Brian Qu
     * @param result the result list
     * @param current the current parenthesis string
     * @param open the count of open bracket in cur parenthesis string
     * @param close the count of close bracket in cur parenthesis string
     * @since 2023-12-27 19:15
     */
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // if cur string length meets the limit, add it to result
        if (current.length() == max * 2) {
            result.add(current);
            // return to explore other paths
            return;
        }

        // if the open bracket is less than max, we can add open parenthesis
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // if the close bracket is less than the open bracket, we can add close parenthesis
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
