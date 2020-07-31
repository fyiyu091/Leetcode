package miscellaneous;

import java.util.HashMap;
import java.util.Map;

/*
    Use a length size array, each element is a map<k, v>, k is the snapId while v is the val for that snapId at the array idx
    Save the space for the unchanged ones
 */
public class SnapshotArray {
    private Map[] arr;
    private int snapId;
    public SnapshotArray(int length) {
        arr = new HashMap[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new HashMap<Integer, Integer>();
        }
    }

    public void set(int index, int val) {
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    /*
     Check from the snap_id all the way back down to 0, if seeing the map containsKey, it is the value then, otherwise is 0

          (4, 8)
          (1, 2)
          (0, 1)
     0     1     2
     For snap_id == 3, it should be from (1, 2) which is 2, so looping down from 3 to 2 to 1 and find 2 as the value
     */

    public int get(int index, int snap_id) {
        Map<Integer, Integer> map = arr[index];
        for (int i = snap_id; i >= 0; i--) {
            if (map.containsKey(i)) {
                return map.get(i);
            }
        }
        return 0;
    }
}
