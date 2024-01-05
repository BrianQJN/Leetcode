/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-05
 */
public class remove_nth_node_from_end_of_list_19 {
    /**
     * @implSpec Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * @author Brian Qu
     * @param head the head of a singly linked list
     * @param n the nth node to be removed
     * @return ListNode - the head of the removed linked list
     * @since 2024-01-05 15:44
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create a dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move both pointers until the faster reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove the nth from the list
        slow.next = slow.next.next;

        return dummy.next;
    }
}
