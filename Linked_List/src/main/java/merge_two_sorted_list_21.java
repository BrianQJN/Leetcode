/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-04
 */
public class merge_two_sorted_list_21 {
    /**
     * @implSpec You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     * @author Brian Qu
     * @param list1 the list to be merged
     * @param list2 the list to be merged
     * @return ListNode - the merged linked list
     * @since 2024-01-04 18:22
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // initialize a dummy node, and a tail node points to the dummy node
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            // compare the value of nodes in the two linked list
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            // move tail to the end of the linked list
            tail = tail.next;
        }

        // link the remaining nodes of list1 or list2
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
