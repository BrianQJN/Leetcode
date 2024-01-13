import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-13
 */
public class Last_Stone_Weight_1046 {
    /**
     * @implSpec You are given an array of integers stones where stones[i] is the weight of the ith stone.
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
     * If x == y, both stones are destroyed, and
     * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     * At the end of the game, there is at most one stone left.
     * Return the weight of the last remaining stone. If there are no stones left, return 0.
     * @author Brian Qu
     * @param stones an array of integers represents the weight of the ith stone
     * @return int - the weight of the last remaining stone, if no stone left, return 0
     * @since 2024-01-13 14:21
     */
    public int lastStoneWeight(int[] stones) {
        // initialize a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // put the original stone into heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x < y) {
                int diff = y - x;
                maxHeap.add(diff);
            }
        }

        return (maxHeap.size() == 1) ? maxHeap.peek() : 0;
    }
}
