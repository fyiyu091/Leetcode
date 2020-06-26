package datastructure;

import java.util.*;

public class RandomizedSet {
    // Key is element, value is the index of that element in the list
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // Can still handle only one element case
        int idx = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
