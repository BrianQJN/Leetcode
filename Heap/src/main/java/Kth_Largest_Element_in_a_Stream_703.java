import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-13
 */
public class Kth_Largest_Element_in_a_Stream_703 {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    /**
     * @implSpec Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * Implement KthLargest class:
     * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
     * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
     * @author Brian Qu
     * @param k the number of largest elements we want to keep
     * @param nums the original array of integers
     * @since 2024-01-13 13:53
     */
    public Kth_Largest_Element_in_a_Stream_703(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
