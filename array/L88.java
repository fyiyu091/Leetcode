package array;

/* Merge two sorted array */

public class L88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }

        // Start from the end why?
        // The value will not be overriden
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
            else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }

        while (n-- > 0) {
            nums1[n] = nums2[n];
        }
    }
}
