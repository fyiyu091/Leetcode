package array;

/* Plus one
   [1,2,3,4] -> [1,2,3,5]
   [8,9,9] -> [9,0,0]
   [9,9,9] -> [1,0,0,0]
 */
public class L66 {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        // If reach this point, meaning we will have one more digit
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
