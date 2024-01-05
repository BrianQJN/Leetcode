/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-04
 */
public class reorder_list_143 {
    /**
     * @implSpec You are given the head of a singly linked-list. The list can be represented as:
     * L0 → L1 → … → Ln - 1 → Ln
     * Reorder the list to be on the following form:
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     * @author Brian Qu
     * @param head the head of a singly linked list
     * @since 2024-01-04 21:23
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find the middle of the original linked list using slow fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the linked list
        ListNode pre = null, cur = slow, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // merge the two part of the linked list
        ListNode first = head, second = pre;
        while (second.next != null) {
            next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }
    }
}
