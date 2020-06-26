package microsoftoa;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {
    public String dayOfWeek(String s, int k) {
        String[] day = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        // map to store the day to the index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            map.put(day[i], i);
        }

        return day[(map.get(s) + k) % 7];
    }
}
