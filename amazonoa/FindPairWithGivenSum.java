package amazonoa;

import java.util.*;

public class FindPairWithGivenSum {
    private List<Integer> twoSum(List<Integer> nums, int target) {
        if (nums == null || nums.size() <= 1) {
            return null;
        }

        List<Integer> res = Arrays.asList(-1, -1);

        Map<Integer, Integer> map = new HashMap<>();

        int max = -1;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if ((nums.get(i) > max || complement > max) && map.containsKey(complement)) {
                res.set(0, i);
                res.set(1, map.get(complement));
                max = Math.max(nums.get(i), complement);
            }
            map.put(nums.get(i), i);
        }

        if (res.get(0) == -1 && res.get(1) == -1) {
            return null;
        }

        return res;
    }
}
