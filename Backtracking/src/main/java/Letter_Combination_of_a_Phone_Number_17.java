import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-16
 */
public class Letter_Combination_of_a_Phone_Number_17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * @param digits a string contains digits from 2-9 inclusive
     * @return List<String> - all possible letter combinations the number could represent
     * @implSpec Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     * @author Brian Qu
     * @since 2024-01-16 14:36
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        backtrack(digits, new StringBuilder(), 0, res);
        return res;
    }

    private void backtrack(String digits, StringBuilder curStr, int index, List<String> res) {
        if (index == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        String letters = KEYS[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            curStr.append(letter);
            backtrack(digits, curStr, index + 1, res);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
