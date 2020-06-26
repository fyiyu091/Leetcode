package amazonoa;

/* Basically just find two pointers to equally partition three sections of an array */

public class LoadBalancer {
    public static boolean partition(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 2;
        int midSum = 0;
        for (int i = 2; i <= len - 3; i++) {
            midSum += nums[i];
        }
        int leftSum = nums[0];
        int rightSum = nums[len - 1];

        while (left + 2 <= right) {
            if (leftSum == rightSum && leftSum == midSum) {
                return true;
            }
            if (leftSum < rightSum) {
                leftSum += nums[left];
                left++;
                midSum -= nums[left];
            }
            else {
                rightSum += nums[right];
                right--;
                midSum -= nums[right];
            }
        }

        return false;
    }
}
