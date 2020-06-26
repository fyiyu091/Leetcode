package array;

/* Two pointers move from sides to center */

public class L11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(height[left] * (right - left), max);
                left++;
            }
            else {
                max = Math.max(height[right] * (right - left), max);
                right--;
            }
        }

        return max;
    }
}
