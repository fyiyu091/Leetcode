package microsoftoa;

import java.lang.reflect.Array;
import java.util.*;

public class AirplaneSeatReserve {
    public int airplaneSeatReserve(String s, int n) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }

        String[] strs = s.split("\\W");
        for (String str : strs) {
            map.get(Integer.valueOf(str.substring(0, str.length() - 1))).add(str.charAt(str.length() - 1));
        }

        for (int row : map.keySet()) {
            Set<Character> set = map.get(row);
            if (!set.contains('B') && !set.contains('C') && !set.contains('D') && !set.contains('E')) {
                res++;
                set.addAll(Arrays.asList('B','C','D','E'));
            }
            if(!set.contains('D') && !set.contains('E') && !set.contains('F') && !set.contains('G')) {
                res++;
                set.addAll(Arrays.asList('D', 'E', 'F', 'G'));
            }
            if(!set.contains('F') && !set.contains('G') && !set.contains('H') && !set.contains('J')) {
                res++;
                set.addAll(Arrays.asList('F', 'G', 'H', 'J'));
            }
        }
        return res;
    }
}
