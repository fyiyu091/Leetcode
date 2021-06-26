package array;

/*
    Find whether we an divide the array into n / 2 pairs such that the sum of each pair is divisible by k
 */
public class L1497 {
    public boolean canArrange(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        int[] count = new int[k];
        for (int num : arr) {
            count[((num % k) + k) % k]++;
        }

        if (count[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if ((count[i] + count[k - i]) % 2 != 0) { //TODO, will fail [-1,-1,-1,-1,2,2,-2,-2] case
                return false;
            }
        }

        return true;
    }
}
