import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-22
 */
public class top_k_frequent_elements_347 {
    /**
     * @implSpec Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     * @author Brian Qu
     * @param nums an integer array to find the k frequent elements
     * @param k the k most frequent
     * @return array of the k most frequent elements
     * @since 2023-12-22 14:28
     */
    public int[] topKFrequent(int[] nums, int k) {
        // initialize a HashMap to record the frequency of each element, and a min-heap to keep track of k most frequent
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));

        // iterate through the array nums and count the frequency
        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // iterate through the map key set, add it to the min-heap
        for (int num: frequencyMap.keySet()) {
            minHeap.add(num);
            // if the length of min heap exceed k, pop the least frequent one
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // initialize the result array
        int size = minHeap.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
