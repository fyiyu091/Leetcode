package microsoftoa;

public class InsertToMaxVal {
    public static int getMaxByInsertK(int n, int k) {
        if (n == 0) {
            return k * 10 + n;
        }

        int sign = 1;
        if (n < 0) {
            sign *= -1;
        }

        int absVal = Math.abs(n);
        int digits = 0;
        int position = 1;
        int max = Integer.MIN_VALUE;
        int curr = absVal;

        // Get how many digits we have
        while (curr > 0) {
            digits++;
            curr /= 10;
        }

        // digits + 1 place to insert
        for (int i = 0; i <= digits; i++) {
            // Brute force to try insert the number at the current position, from least to most
            int newVal = (absVal / position) * (position * 10) + (k * position) + (absVal % position);

            if (newVal * sign > max) {
                max = newVal * sign;
            }
            position *= 10;
        }

        return max;
    }
}
