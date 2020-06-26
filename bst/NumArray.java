package bst;

/* Range sum query
*  The indexTree stores the partial prefixSum info
* */

public class NumArray {
    private int[] arr;
    private int[] indexTree;

    public NumArray(int[] nums) {
        this.arr = new int[nums.length];
        this.indexTree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
            arr[i] = nums[i];
        }
    }

    public void update(int i, int val) {
        int diff = val - arr[i]; // The amount that we will need to update
        arr[i] = val;
        i++; // in the indexTree the index is offset by 1
        while (i <= arr.length) {
            indexTree[i] += diff;
            i += i & (-i);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    private int sum(int i) {
        int ii = i + 1;
        int sum = 0;
        while (ii >= 1) {
            sum += indexTree[ii];
            ii -= ii & (-ii);
        }
        return sum;
    }
}
