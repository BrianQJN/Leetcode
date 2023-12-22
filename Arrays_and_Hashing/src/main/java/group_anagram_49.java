import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-22
 */
public class group_anagram_49 {
    /**
     * @implSpec Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * @author Brian Qu
     * @param strs the strings to group
     * @return the grouped anagrams List
     * @since 2023-12-22 13:26
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // If strs are empty or null, return empty List
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Initialize a HashMap to record the sorted str and its anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through the array strs
        for (String str: strs) {
            // convert str to char array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // if it is a new key, put it into map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
