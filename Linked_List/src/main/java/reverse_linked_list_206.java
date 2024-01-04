/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-04
 */
public class reverse_linked_list_206 {
    /**
     * @implSpec Given the head of a singly linked list, reverse the list, and return the reversed list.
     * @author Brian Qu
     * @param head the head of a singly linked list
     * @return ListNode - the reversed list
     * @since 2024-01-04 17:35
     */
    public ListNode reverseList(ListNode head) {
        // initialize three pointers
        ListNode pre = null, cur = head, next = null;

        // traverse the linked list
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // update the new head
        head = pre;
        return head;
    }

    // ListNode class
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
