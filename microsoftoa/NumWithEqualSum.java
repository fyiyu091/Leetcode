package microsoftoa;

import java.util.HashMap;
import java.util.Map;

public class NumWithEqualSum {
    public static int numSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for (int num : nums) {
            int digitAdd = getDigitAdd(num);
            if (!map.containsKey(digitAdd)) {
                map.put(digitAdd, num);
            }
            else {
                // Update the global res every time we have two integer with the same digit sum
                res = Math.max(res, num + map.get(digitAdd));
                // Keep just one value for each key
                map.put(digitAdd, Math.max(map.get(digitAdd), num));
            }
        }

        return res;
    }

    private static int getDigitAdd(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSum(new int[] {51,71,17,42}));
        System.out.println(numSum(new int[] {42,33,60}));
        System.out.println(numSum(new int[] {51, 32, 43}));
    }
}
