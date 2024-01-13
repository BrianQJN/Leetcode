import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-13
 */
public class Kth_Largest_Element_in_an_Array_215 {
    /**
     * @implSpec Given an integer array nums and an integer k, return the kth largest element in the array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * Can you solve it without sorting?
     * @author Brian Qu
     * @param nums an integer array
     * @param k the kth element we need to find
     * @return int - the kth largest element
     * @since 2024-01-13 15:44
     */
    public int findKthLargest(int[] nums, int k) {
        // initialize a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
