package microsoftoa;

import java.util.HashMap;
import java.util.Map;

public class LargestXOccurXTimes {
    public static int getLargest(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                if (key > res) {
                    res = key;
                }
            }
        }
        return res;
    }
}
