package array;

public class KthTwoSortedArray {
    public int find(int[] nums1, int[] nums2, int k) {
        // corner case

        return find(nums1, 0, nums2, 0, k);
    }

    // The kth, will need k - 1
    private int find(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 > nums1.length - 1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > nums2.length - 1) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int tmp1 = Integer.MAX_VALUE;
        int tmp2 = Integer.MAX_VALUE;

        if (start1 + k / 2 - 1 < nums1.length) {
            tmp1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            tmp2 = nums2[start2 + k / 2 - 1];
        }

        if (tmp1 < tmp2) {
            return find(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
        else {
            return find(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
