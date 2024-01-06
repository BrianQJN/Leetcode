/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec Each node point to a next node and random node
 * @since 2024-01-06
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
