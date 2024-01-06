/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-06
 */
public class copy_list_with_random_pointer_138 {
    /**
     * @implSpec A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
     * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
     * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
     * Return the head of the copied linked list.
     * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
     * val: an integer representing Node.val
     * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
     * Your code will only be given the head of the original linked list.
     * @author Brian Qu
     * @param head the original linked list with random pointer.
     * @return Node - the deep copy of the original one.
     * @since 2024-01-06 16:14
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // create copied nodes interleaved with original nodes
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // copy random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // separate the original and copied lists
        Node copyHead = head.next;
        Node copy = copyHead;
        cur = head;
        while (cur != null) {
            cur.next = cur.next.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            cur = cur.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
