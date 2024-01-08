/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-07
 */
public class linked_list_cycle_141 {
    /**
     * @implSpec Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     * @author Brian Qu
     * @param head the head of a linked list
     * @return boolean - if the linked list has a cycle, return true, else false
     * @since 2024-01-07 19:06
     */
    public boolean hasCycle(ListNode head) {
        // initialize the fast-slow pointers
        ListNode slow = head, fast = head;

        // iterate through the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // cycle detected
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
