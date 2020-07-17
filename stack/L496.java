package stack;

/*
   Find the next greater element
   The first greater or first smaller
   Think about stack
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        // a value and its first max in nums2
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for (int i = 0; i < nums1.length; i++) {
            int val = (map.get(nums1[i]) == null) ? -1 : map.get(nums1[i]);
            res[i] = val;
        }
        return res;
    }
}
