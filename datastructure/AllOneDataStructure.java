package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
   Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
   Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1.
   GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
   GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 */

public class AllOneDataStructure {
    class Node {
        private int val;
        private List<String> strs;
        private Node prev;
        private Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, String str) {
            this.val = val;
            this.strs = new ArrayList<>();
            this.strs.add(str);
        }
    }

    private Map<String, Node> map;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public AllOneDataStructure() {
        this.map = new HashMap<>();
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.prev = tail;
        this.tail.next = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNewBucketAndUpdateMap(Node leftNode, Node rightNode, Map<String, Node> map, String key, int newVal) {
        Node newNode = new Node(newVal, key);
        leftNode.next = newNode;
        newNode.next = rightNode;
        rightNode.prev = newNode;
        newNode.prev = leftNode;
        map.put(key, newNode);
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node node = map.get(key);
        if (node != null) {
            int newVal = node.val + 1;
            node.strs.remove(key);
            map.remove(key);
            Node nextNode = node.next;
            // this means that we will need to create a new node
            if (nextNode.val != newVal) {
                insertNewBucketAndUpdateMap(node, nextNode, map, key, newVal);
            }
            else {
                nextNode.strs.add(key);
                map.put(key, nextNode);
            }
            if (node.strs.isEmpty()) {
                remove(node);
            }
        }
        else {
            Node nextNode = tail.next;
            if (nextNode.val != 1) {
                insertNewBucketAndUpdateMap(tail, nextNode, map, key, 1);
            }
            else {
                nextNode.strs.add(key);
                map.put(key, nextNode);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node node = map.get(key);
        if (node != null) {
            int val = node.val;
            node.strs.remove(key);
            map.remove(key);
            if (val != 1) {
                int newVal = val - 1;
                Node prevNode = node.prev;
                if (prevNode.val != newVal) {
                    insertNewBucketAndUpdateMap(prevNode, node, map, key, newVal);
                }
                else {
                    prevNode.strs.add(key);
                    map.put(key, prevNode);
                }
            }
            if (node.strs.isEmpty()) {
                remove(node);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Node maxValNode = head.prev;
        if (maxValNode.val == 0) {
            return "";
        }
        return maxValNode.strs.get(0);
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Node minValNode = tail.next;
        if (minValNode.val == 0) {
            return "";
        }
        return minValNode.strs.get(0);
    }
}
