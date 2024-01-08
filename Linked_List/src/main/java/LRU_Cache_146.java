import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-07
 */
public class LRU_Cache_146 {
    static class ListNode {
        int key, value;
        ListNode prev, next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, ListNode> map;
    private final ListNode head, tail;

    public LRU_Cache_146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(ListNode node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            removeNode(node);
        } else {
            node = new ListNode(key, value);
            map.put(key, node);
            if (map.size() > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
        addToHead(node);
    }
}
