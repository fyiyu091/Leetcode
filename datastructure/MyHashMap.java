package datastructure;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {
    private static class Cell<K, V> {
        private K key;
        private V val;
        private Cell(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setVal(V val) {
            this.val = val;
        }

        @Override
        public int hashCode() {
            return key == null ? 0 : key.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Cell) {
                Cell<K, V> that = (Cell<K, V>) o;
                if (key == null) {
                    return that.key == null;
                }
                else {
                    /* To compare two cells, we just need to verify if the key is the same, don't need
                       to worry about the value
                     */
                    return key.equals(that.key);
                }
            }
            else {
                return false;
            }
        }
    }

    private static final int INIT_CAP = 256;
    private static final double LOAD_FACTOR = 0.75;
    private int capacity;
    private int size;
    private List<Cell<K, V>>[] buckets;

    public MyHashMap() {
       this(INIT_CAP);
    }

    public MyHashMap(int capacity) {
        buckets = (LinkedList<Cell<K, V>>[]) new LinkedList[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void put(K key, V val) {
        // Find the bucket
        int idx = hashCodeOfKey(key);
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<Cell<K, V>>();
        }

        List<Cell<K, V>> list = buckets[idx];
        for (Cell cell : list) {
            if (cell.getKey().equals(key)) {
                // The method here is remove first then add later, this way is easier
                list.remove(cell);
                size--;
                break;
            }
        }

        list.add(new Cell(key, val));
        size++;
        if (size >= capacity * LOAD_FACTOR) {
            reHash();
        }
    }

    public V get(K key) {
        List<Cell<K, V>> list = buckets[hashCodeOfKey(key)];
        if (list == null) {
            return null;
        }
        else {
            for (Cell cell : list) {
                if (cell.getKey().equals(key)) {
                    return (V) cell.getVal();
                }
            }
        }
        return null;
    }

    public boolean remove(K key) {
        List<Cell<K, V>> list = buckets[hashCodeOfKey(key)];
        if (list == null) {
            return false;
        }
        for (Cell cell : list) {
            if (cell.getKey().equals(key)) {
                list.remove(cell);
                return true;
            }
        }
        return false;
    }

    // Instantiate new double capacity bucket, move based on new hashCodeOfKey
    private void reHash() {
        capacity = capacity * 2;
        List<Cell<K, V>>[] newBuckets = (LinkedList<Cell<K, V>>[]) new LinkedList[capacity];
        for (List<Cell<K, V>> list : buckets) {
            if (list != null) {
                for (Cell<K, V> cell : list) {
                    int idx = hashCodeOfKey(cell.getKey());
                    if (newBuckets[idx] == null) {
                        newBuckets[idx] = new LinkedList<Cell<K, V>>();
                    }
                    newBuckets[idx].add(cell);
                }
            }
        }
        buckets = newBuckets;
    }

    private int hashCodeOfKey(K key) {
        return key == null ? 0 : key.hashCode() % capacity;
    }
}
