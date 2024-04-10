import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-10
 */
public class Alien_Dictionary_269 {
    /**
     * @param words a list of strings that the strings in words are sorted lexicographically
     * @return string - a string of the unique letters in the new alien language sorted in lexicographically
     * @implSpec There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.
     * You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are
     * sorted lexicographically
     *  by the rules of this new language.
     * If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".
     * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.
     * @author Brian Qu
     * @since 2024-04-10 11:29
     */
    public String alienOrder(String[] words) {
        // build the graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // add edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.startsWith(word2) && !word1.equals(word2)) return "";

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j), child = word2.charAt(j);
                if (parent != child) {
                    if (graph.get(parent).add(child)) {
                        inDegree.put(child, inDegree.get(child) + 1);
                    }
                    break; // found the first differing character
                }
            }
        }

        // topological sort
        Queue<Character> queue = new LinkedList<>();
        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            sb.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // check if there is a cycle
        if (sb.length() < inDegree.size()) return "";

        return sb.toString();
    }
}
