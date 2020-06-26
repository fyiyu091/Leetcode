package dfs;

public class L698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        boolean[] visited = new boolean[nums.length];
        return dfs(nums, 0, 0, sum / k, visited, k);
    }

    private boolean dfs(int[] nums, int startIdx, int sumSoFar, int target, boolean[] visited, int k) {
        // sum is dividable by k, if only one piece is left, it must be sum / k, so just return true
        if (k == 1) {
            return true;
        }
        if (sumSoFar == target) {
            return dfs(nums, 0, 0, target, visited, k - 1);
        }

        for (int i = startIdx; i < nums.length; i++) {
            if (!visited[i] && (sumSoFar + nums[i]) <= target) {
                visited[i] = true;
                if (dfs(nums, i + 1, sumSoFar + nums[i], target, visited, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}
