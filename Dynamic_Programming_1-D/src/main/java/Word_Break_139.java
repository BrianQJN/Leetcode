import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-17
 */
public class Word_Break_139 {
    /**
     * @param s the target string
     * @param wordDict a dictionary of strings
     * @return boolean - return true if string s can be segmented into a space-seperated sequence
     * @implSpec Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     * @author Brian Qu
     * @since 2024-02-17 16:38
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
