package datastructure;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class ListNode {
        private int key;
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode() {}

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    private Map<Integer, ListNode> map;
    private ListNode dummyTail;
    private ListNode dummyHead;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHead = new ListNode();
        this.dummyTail = new ListNode();
        this.size = 0;
        dummyTail.next = dummyHead;
        dummyHead.prev = dummyTail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            synchronized (this) {
                removeNode(node);
                addToHead(node);
            }
            node.val = value;
            return;
        }
        else {
            if (this.capacity == 0) {
                return;
            }
            synchronized (this) {
                if (this.size == this.capacity) {
                    map.remove(dummyTail.next.key);
                    removeNode(dummyTail.next);
                }
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                addToHead(node);
            }
            return;
        }
    }

    private void addToHead(ListNode node) {
        node.prev = dummyHead.prev;
        node.next = dummyHead;
        dummyHead.prev.next = node;
        dummyHead.prev = node;
        size++;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
}

