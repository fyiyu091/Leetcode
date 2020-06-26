package microsoftoa;

public class ParticleVelocity {
    public int particleVelocity(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]) {
                res++;
                for (int j = i + 3; j < nums.length; j++) {
                    if (nums[j] - nums[j - 1] == nums[i + 2] - nums[i + 1]) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
