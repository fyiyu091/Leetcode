package array;

/* Median of two sorted arrays */

public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l = (len1 + len2 + 1) / 2; // left half of the median, here is median th
        int r = (len1 + len2 + 2) / 2; // right half of the median, here is median th
        // Both odd and even case will work
        return (helper(nums1, 0, nums2, 0, l) + helper(nums1, 0, nums2, 0, r)) / 2.0;
    }

    // Find the kth smallest in nums1 and nums2
    private int helper(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 0 1 2, standing at 0, the 1 smallest is 0 so it is 1 - 1 translate to k - 1
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

        // Binary reduction idea
        // Why if one array doesn't have enough number, then we keep it at MAX_VALUE?
        // Each time we remove k/2, so the other array already can remove k/2
        if (start1 + k / 2 - 1 < nums1.length) {
            tmp1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            tmp2 = nums2[start2 + k / 2 - 1];
        }

        if (tmp1 < tmp2) {
            // Why here doesn't need k / 2 - 1?
            // k / 2 - 1 has already been compared
            return helper(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
        else {
            return helper(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
