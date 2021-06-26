package kproblems;

/* Top K frequent elements, using count sort to do O(n) */

import java.util.*;

public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // Key is the num and value is the frequency
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

        /*
        We have a bucket that the idx is the frequency and the value is a list of nums
        also, we have a k size array that's to store the results
        Purpose is to fill up the k size array
            num:       5
                   5   6
                   2 1 9 8 7
            idx: 0 1 2 3 4 5
         */
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
