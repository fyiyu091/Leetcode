package amazonoa;

import java.util.*;

public class TopKWords {
    public static List<String> solve(int k, String[] keywords, String[] reviews) {
        // corner case
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String str : keywords) {
            dict.add(str);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String sentence : reviews) {
            String[] strs = sentence.split("\\W");
            Set<String> added = new HashSet<>();
            for (String str : strs) {
                str = str.toLowerCase();
                if (!added.contains(str) && dict.contains(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                    added.add(str);
                }
            }
        }

        Queue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    // If two String have the same frequency, we want the lexicographically larger to be out first
                    return o2.compareTo(o1);
                }
                else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });

        for (String str : map.keySet()) {
            minHeap.offer(str);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll());
        }

        return res;
    }
}
