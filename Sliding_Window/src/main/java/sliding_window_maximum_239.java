import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-25
 */
public class sliding_window_maximum_239 {
    /**
     * @implSpec You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     * Return the max sliding window.
     * @author Brian Qu
     * @param nums an array of integers
     * @param k the sliding window size
     * @return int[] - the max sliding window
     * @since 2023-12-25 20:25
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialization
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int resIndex = 0;

        // traverse the array
        for (int i = 0; i < nums.length; i++) {
            // remove indices that are out of the cur window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // remove indices of all elements smaller than the current from deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // add cur index to the deque
            deque.offer(i);

            // if the first window is fully processed, add the maximum to the result
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peek()];
            }
        }

        return result;
    }
}
