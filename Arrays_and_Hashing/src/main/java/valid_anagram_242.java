import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-21
 */
public class valid_anagram_242 {
    /**
     * @implSpec Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * @author Brian Qu
     * @param s is the original string
     * @param t is the comparison string
     * @return boolean, if t is an anagram of s, return true, else false
     * @since 2023-12-21 22:26
     */
    public boolean isAnagram(String s, String t) {
        // if two strings have diff length, return false
        if (s.length() != t.length()) {
            return false;
        }

        // initialize an array to record the frequency of each letter
        int[] frequency = new int[26];

        // iterate through the strings
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        // iterate the frequency array, if any negative num, return false
        for (int n : frequency) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        // if two strings have different length, return false
        if (s.length() != t.length()) {
            return false;
        }

        // initialize a HashMap to record the characters and their frequencies
        Map<Character, Integer> frequencies = new HashMap<>();

        // iterate through the String s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        // iterate through the String t
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            frequencies.put(c, frequencies.getOrDefault(c, 0) - 1);
            if (frequencies.get(c) < 0) {
                return false;
            } else if (frequencies.get(c) == 0) {
                frequencies.remove(c);
            }
        }

        // if the frequencies is empty, return true
        return frequencies.isEmpty();
    }
}
