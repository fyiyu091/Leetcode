package array;

/* Next permutation
   Rearrange numbers into the lexicographically next greater permutation
   If not possible, rearrange it as the lowest possible order
   1,1,5 -> 1,5,1
   3,2,1 -> 1,2,3

   if it is in descending order like 6 5 4 3 2 1 -> reverse
   Encounter the first a[i - 1] < a[i] from the right side, need to find the smallest element that is larger than a[i - 1] from its right
   swap both, then reverse the right part (i - 1, end]
 */
public class L31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        int i = len - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }

        if (i >= 0) {
            int j = len - 1;
            while (j > i) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1);
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
