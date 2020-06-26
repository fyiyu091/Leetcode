package microsoftoa;

/* The string contains only A and B, minDelete to format all As then Bs */

import org.junit.Assert;

public class MinDeleteObtainFormat {
    public static int minDelete(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int minDel = 0;
        int countB = 0;

        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            if (ch == 'B') {
                countB++;
            }
            else {
                minDel = Math.min(minDel + 1, countB);
            }
        }

        return minDel;
    }

    public static void main(String[] args) {
        Assert.assertEquals(minDelete("AAABBB"), 3);
    }
}
