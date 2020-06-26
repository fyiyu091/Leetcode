package kproblems;

/* find median of two sorted array with O(log(m + n)) */

public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = 0;
        int right = len1;

        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - mid1;
            int maxLeft1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = mid1 == len1 ? Integer.MAX_VALUE : nums1[mid1];
            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = partition2 == len2 ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                }
                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            else if (maxLeft1 > minRight2) {
                right = mid1 - 1;
            }
            else {
                left = mid1 + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
