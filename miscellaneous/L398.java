package miscellaneous;

import java.util.Random;

/* Random pick index
   [1,2,3,3,3]
   pick(3): data source is 3's index: 2,3,4 sample is just one index so can just be 0
 */
public class L398 {
    private int[] nums;
    public L398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int sample = 0;
        for (int i = 0; i < target; i++) {
            if (nums[i] == target) {
                count++;
                int idx = new Random().nextInt(count);
                if (idx == 0) {
                    sample = i;
                }
            }
        }
        if (count == 0) {
            throw new IllegalStateException();
        }
        return sample;
    }
}
