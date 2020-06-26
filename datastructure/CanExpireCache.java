package datastructure;

import java.util.HashMap;
import java.util.Map;

public class CanExpireCache {
    class ListNode {
        private int val;
        private int key;
        private long timestamp;
        private ListNode prev;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
            this.timestamp = System.currentTimeMillis();
        }
    }

    private static final int DEFAULT_CAPACITY = 100;
    private int capacity;
    private int size;
    private Map<Integer, ListNode> map;
    private ListNode dummyHead;
    private ListNode dummyTail;

    public CanExpireCache() {
        this(DEFAULT_CAPACITY);
    }

    public CanExpireCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new ListNode(0, 0);
        dummyTail = new ListNode(0, 0);
        this.size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        else {
            ListNode node = map.get(key);
            remove(node);
            addToHead(node);
            return node.val;
        }
    }

    public void add(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            addToHead(node);
            node.val = value;
        }
        else {
            if (capacity == size) {
                map.remove(dummyTail.next.key);
                remove(dummyTail.next);
            }
            ListNode addNode = new ListNode(key, value);
            map.put(key, addNode);
            addToHead(addNode);
        }
    }

    public void removeByDate(long ts) {
        ListNode curr = dummyTail.next;
        while (curr.timestamp < ts && curr != null) {
            ListNode next = curr.next;
            remove(curr);
            curr = next;
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private void addToHead(ListNode node) {
        ListNode prev = dummyHead.prev;
        prev.next = node;
        node.prev = prev;
        node.next = dummyHead;
        dummyHead.prev = node;
        size++;
    }
}
