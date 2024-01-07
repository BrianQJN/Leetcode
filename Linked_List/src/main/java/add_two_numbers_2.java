/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-07
 */
public class add_two_numbers_2 {
    /**
     * @implSpec You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * @author Brian Qu
     * @param l1 the linked list represents a non-negative integer
     * @param l2 the linked list represents a non-negative integer
     * @return ListNode - the sum of the two integers
     * @since 2024-01-07 18:32
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // initialize a dummy node and a carry digit
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;

        // iterate through each digit
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return dummy.next;
    }
}
