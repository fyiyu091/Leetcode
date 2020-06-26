package array;

/* Sort colors
   [0, p0)   all 0s
   [p0, p1)  all 1s
   [p1, p2]  unchecked
   (p2, len) all 2s
* */

public class L75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        int p0 = 0;
        int p1 = 0;
        int p2 = len - 1;

        while (p1 <= p2) {
            if (nums[p1] == 1) {
                p1++;
            }
            else if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
                p1++;
            }
            else {
                swap(nums, p1, p2);
                p2--;
            }
        }

        return;
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
