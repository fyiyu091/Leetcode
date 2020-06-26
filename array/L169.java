package array;

/* Find the more than n/2 times number in the array */
/* The Boyer-Moore voting algorithm */
public class L169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        // two variable, tracking the val and its count
        int[] arr = new int[2];

        for (int n : nums) {
            if (arr[1] == 0) {
                arr[0] = n;
                arr[1] = 1;
            }
            else {
                if (n == arr[0]) {
                    arr[1]++;
                }
                else {
                    arr[1]--;
                }
            }
        }

        // The majority number doesn't necessary means it's over len / 2
        int count = 0;
        for (int n : nums) {
            if (n == arr[0]) {
                count++;
            }
        }
        return count > nums.length / 2 ? arr[0] : -1;
    }
}
