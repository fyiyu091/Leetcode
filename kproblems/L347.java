package kproblems;

/* Top K frequent elements, using count sort to do O(n) */

import java.util.*;

public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        // The index of the bucket means the frequency of the element
        List<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[len + 1];

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                List<Integer> elements = new ArrayList<>();
                bucket[map.get(key)] = elements;
            }
            bucket[map.get(key)].add(key);
        }

        // Have a bucket and how to store it to res array
        // Will iterate all the element in the bucket array
        int idx = res.length - 1;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    if (idx < 0) {
                        break;
                    }
                    else {
                        res[idx--] = bucket[i].get(j);
                    }
                }
            }
        }

        return res;
    }
}
