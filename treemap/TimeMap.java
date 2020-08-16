package treemap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    1. set(string key, string value, int timestamp)
    Stores the key and value, along with the given timestamp.

    2. get(string key, int timestamp)
    Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.

    One key can have multiply values that are at different timestamp
 */
public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }

        Integer floor = treeMap.floorKey(timestamp);
        if (floor == null) {
            return "";
        }
        // If floor is null, treeMap.get(null) will throw NullPointerException
        return treeMap.get(floor);
    }
}
