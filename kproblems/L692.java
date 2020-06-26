package kproblems;

import java.util.*;

public class L692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)) {
                    return map.get(o1) - map.get(o2);
                }
                else {
                    return o2.compareTo(o1);
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
