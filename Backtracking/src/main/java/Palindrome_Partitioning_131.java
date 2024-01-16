import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-16
 */
public class Palindrome_Partitioning_131 {
    /**
     * @implSpec Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s
     * @author Brian Qu
     * @param s a string
     * @return List<List<String>> - all possible palindrome partitioning of s
     * @since 2024-01-16 14:16
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> curList, List<List<String>> res) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int end = start; end < s.length(); end ++) {
            if (isPalindrome(s, start, end)) {
                curList.add(s.substring(start, end+1));
                backtrack(s, end+1, curList, res);
                curList.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
