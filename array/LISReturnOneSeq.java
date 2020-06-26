package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LISReturnOneSeq {
    public List<Integer> longestIncreaseSequenceOneSeq(int[] nums) {
        List<Integer> buffer = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // Path only stores from idx to idx
        Map<Integer, Integer> path = new HashMap<>();
        for (int num : nums) {
            int idx = findIdx(buffer, num);
            if (idx != 0 && buffer.size() != 0) {
                path.put(num, buffer.get(idx - 1));
            }
            if (idx == buffer.size()) {
                buffer.add(num);
            }
            else {
                buffer.set(idx, num);
            }
        }

        int start = buffer.get(buffer.size() - 1);
        res.add(start);
        while (path.containsKey(start)) {
            res.add(0, path.get(start));
            start = path.get(start);
        }
        return res;
    }

    private int findIdx(List<Integer> buffer, int num) {
        int left = 0;
        int right = buffer.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (buffer.get(mid) >= num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LISReturnOneSeq test = new LISReturnOneSeq();
        int[] nums = {1,1,2,10,14,3,5,7};
        System.err.println(test.longestIncreaseSequenceOneSeq(nums));
    }
}
