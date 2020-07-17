package possibilities;

import java.util.Arrays;
import java.util.Random;

public class L384 {
    private int[] original;

    public L384(int[] nums) {
        this.original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (original == null || original.length <= 1) {
            return original;
        }

        Random rand = new Random();
        int[] res = Arrays.copyOf(original, original.length);
        int len = res.length;
        for (int i = len - 1; i >= 1; i--) {
            int idx = rand.nextInt(i + 1);
            swap(res, i, idx);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
