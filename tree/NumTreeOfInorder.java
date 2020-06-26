package tree;

/* Give inorder traversal array, find how many different tree can it construct */

public class NumTreeOfInorder {
    public static int numOfTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return dfs(nums, nums.length);
    }

    private static int dfs(int[] nums, int length) {
        if (length <= 1) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            int leftVal = dfs(nums, i);
            int rightVal = dfs(nums, length - i - 1);
            res += leftVal * rightVal;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numOfTree(new int[] {1,2,3,4,5,7}));
    }
}
