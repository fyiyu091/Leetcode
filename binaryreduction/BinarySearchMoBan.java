package binaryreduction;

public class BinarySearchMoBan {
    public int moBanOne(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        // need post processing
        if (nums[left] == target) {
            return left;
        }
        else if (nums[right] == target) {
            return right;
        }
        else {
            return -1;
        }
    }

    public int moBanTwo(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return -1;
    }

    public int moBanThree(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchMoBan test = new BinarySearchMoBan();
        int[] oneEle = {5};
        int[] twoEle = {5, 10};
        int[] oddEle = {1,3,4,5,6};
        int[] evenEle = {2,4,5,6,7,8};
        System.err.println(test.moBanOne(evenEle, 3));
    }
}
