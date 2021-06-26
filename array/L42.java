package array;

/* The optimal solution will be the space O(1) two pointers from both sides to middle, update leftMax and rightMax*/

public class L42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;
        int left = 0;
        int right = len - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                // Why we can define the leftMax be the minMax, because we won't find any height that will be
                // smaller
                res += leftMax - height[left];
                left++;
            }
            else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
//    public int trap(int[] height) {
//        if (height == null || height.length <= 2) return 0;
//
//        int res = 0;
//        int i = 0;
//        int len = height.length;
//        Stack<Integer> stack = new Stack<>();
//
//        while (i < len) {
//            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
//                int h = stack.pop();
//
//                if (stack.isEmpty()) {
//                    break;
//                }
//
//                int l = stack.peek();
//
//                int distance = i - l - 1;
//                int waterH = Math.min(height[l], height[i]) - height[h];
//                res += waterH * distance;
//            }
//            stack.push(i++);
//        }
//        return res;
//    }

}
