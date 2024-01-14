import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-14
 */
public class Find_Median_from_Data_Stream_295 {
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public Find_Median_from_Data_Stream_295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
