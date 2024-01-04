import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-03
 */
public class time_based_keyValue_store_981 {
    private final Map<String, List<Pair<String, Integer>>> map;

    /**
     * @implSpec Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
     * Implement the TimeMap class:
     * TimeMap() Initializes the object of the data structure.
     * @author Brian Qu
     * @since 2024-01-03 18:25
     */
    public time_based_keyValue_store_981() {
        map = new HashMap<>();
    }

    /**
     * @implSpec Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
     * void set(String key, String value, int timestamp) Stores the key with the value at the given time timestamp.
     * @author Brian Qu
     * @param key the key to store
     * @param value the corresponding value
     * @param timestamp the timestamp of this value
     * @since 2024-01-03 18:34
     */
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(key, timestamp));
    }

    /**
     * @implSpec Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
     * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
     * @author Brian Qu
     * @param key the key to get value
     * @param timestamp the maximum timestamp to retrieve the value
     * @return String - the most recent value based on the timestamp
     * @since 2024-01-03 18:35
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair<String, Integer>> pairs = map.get(key);
        return binarySearch(pairs, timestamp);
    }

    // helper function to do the binary search
    public String binarySearch(List<Pair<String, Integer>> pairs, int timestamp) {
        // initialize the boundaries
        int left = 0, right = pairs.size() - 1;

        // shrink the search range
        while (left <= right) {
            // calculate the mid
            int mid = left + (right - left) / 2;

            if (pairs.get(mid).second <= timestamp) {
                if (mid == pairs.size() - 1 || pairs.get(mid + 1).second > timestamp) {
                    return pairs.get(mid).first;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "";
    }

    // the Pair class to store the value and timestamp
    static class Pair<V, T> {
        V first;
        T second;

        public Pair(V first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}
