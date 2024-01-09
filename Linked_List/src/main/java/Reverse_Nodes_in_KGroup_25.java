/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-08
 */
public class Reverse_Nodes_in_KGroup_25 {
    /**
     * @implSpec Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     * @author Brian Qu
     * @param head the head of a linked list
     * @param k the number of the nodes group
     * @return ListNode - the reversed linked list
     * @since 2024-01-08 21:47
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // create dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy, prev = dummy, next = dummy;
        int count = 0;

        // count the number of nodes
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // loop for each node group
        while (count >= k) {
            cur = prev.next;
            next = cur.next;

            // reverse the nodes within a group
            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }

            // move to next group
            count -= k;
            prev = cur;
        }

        return dummy.next;
    }
}
