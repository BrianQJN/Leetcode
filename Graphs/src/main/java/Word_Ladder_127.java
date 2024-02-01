import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-01
 */
public class Word_Ladder_127 {
    /**
     * @param beginWord a string represents the beginning word
     * @param endWord a string represents the end word
     * @param wordList a list of strings to do the transformation
     * @return int - the number of words in the transformation sequence
     * @implSpec A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
     * @author Brian Qu
     * @since 2024-02-01 12:39
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // level by level traversal
            for (int i = 0; i < size; i++) {
                String curWord = queue.remove();
                if (curWord.equals(endWord)) return level;

                // find next words in word ladder
                for (int j = 0; j < curWord.length(); j++) {
                    char[] wordChars = curWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if (wordSet.contains(newWord) && !newWord.equals(curWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);// remove to prevent revisiting
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
