package treemap;

/*
    floorKey is the smaller or equal to the input key
    ceilingKey is the larger or equal to the input key

    |  |
    s1  e1
      |    |  (input)
      s2    e2
          |     |
          s3     e3

    Compare s3 with e1 and s3 with e2
 */

import java.util.TreeMap;

public class MyCalendar {
    private TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        this.treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floor = treeMap.floorKey(start);
        if (floor != null && treeMap.get(floor) > start) {
            return false;
        }
        Integer celing = treeMap.ceilingKey(start);
        if (celing != null && celing < end) {
            return false;
        }

        treeMap.put(start, end);
        return true;
    }
}
