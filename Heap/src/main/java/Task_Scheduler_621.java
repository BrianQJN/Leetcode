import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-13
 */
public class Task_Scheduler_621 {
    /**
     * @implSpec Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
     * However, there is a non-negative integer n that represents the cool down period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     * @author Brian Qu
     * @param tasks a characters array representing the tasks a CPU needs to do
     * @param n the cool down period between two same tasks
     * @return int - the least number of units of times that the CPU will take to finish all tasks
     * @since 2024-01-13 17:50
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(taskCounts.values());

        int unitsUsed = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> freqs = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    freqs.add(maxHeap.poll());
                }
            }

            for (int freq : freqs) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }

            unitsUsed += (maxHeap.isEmpty()) ? freqs.size() : n + 1;
        }

        return unitsUsed;
    }
}
