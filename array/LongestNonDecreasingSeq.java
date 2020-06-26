package array;

/* Find the longest non decreasing subsequence */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestNonDecreasingSeq {
    class Pair {
        private int idx;
        private int val;
        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public List<Integer> longestNonDecreasingSeq(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Pair> buffer = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // map to just store index, the index in nums input array
        Map<Pair, Pair> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = findIdx(buffer, nums[i]); // how can I find the previous index
            Pair tmp = new Pair(i, nums[i]);
            if (idx != 0 && buffer.size() != 0) {
                map.put(tmp, buffer.get(idx - 1));
            }
            if (idx == buffer.size()) {
                buffer.add(tmp);
            }
            else {
                buffer.set(idx, tmp);
            }
        }

        res.add(buffer.get(buffer.size() - 1).val);
        Pair start = buffer.get(buffer.size() - 1);
        while (map.containsKey(start)) {
            res.add(0, map.get(start).val);
            start = map.get(start);
        }

        return res;
    }

    // Function to find the smallest number that is larger than num
    // Because we are looking at non-decreasing sequence, we want to keep duplications
    private int findIdx(List<Pair> buffer, int num) {
        int left = 0;
        int right = buffer.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (buffer.get(mid).val <= num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LongestNonDecreasingSeq test = new LongestNonDecreasingSeq();
        int[] nums = {10,1,8,2,6,5,5,3,3,3,4,2};
        System.out.println(test.longestNonDecreasingSeq(nums));
    }
}
