import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-08
 */
public class Merge_K_Sorted_Lists_23 {
    /**
     * @implSpec You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * Merge all the linked-lists into one sorted linked-list and return it.
     * @author Brian Qu
     * @param lists an array of k linked-list lists
     * @return ListNode - the merged sorted linked-list
     * @since 2024-01-08 12:46
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add the first node of each list to the queue
        for (ListNode list: lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // merge the nodes from the queue
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return dummy.next;
    }
}
