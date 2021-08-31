package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Instead of store the entire array
    We would just store the changes which uses a hashMap to store that
    So we would have a list of hashMap

    ((0,5)), ((0,6))

    S2: could also use a TreeMap to store the idx and value
    this way, when we do get, we can O(logS) search S is number of set calls
 */
public class SnapshotArray {
    List<HashMap<Integer, Integer>> list;

    public SnapshotArray(int length) {
        list = new ArrayList<>();
        list.add(new HashMap<>());
    }

    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }

    public int snap() {
        list.add(new HashMap<>());
        // When return snapId as 0, we already have two hashMap
        // Why do we need the first hashMap?
        return list.size() - 2;
    }

    public int get(int index, int snap_id) {
        for (int i = snap_id; i >= 0; i--) {
            if (list.get(i).containsKey(index)) {
                return list.get(i).get(index);
            }
        }
        return 0;
    }
}
