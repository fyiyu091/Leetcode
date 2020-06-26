package string;

/* String to integer (atoi) */

public class L8 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        int i = 0;
        long res = 0;
        int sign = 1;
        int len = str.length();

        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        if (i < len && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (i < len && str.charAt(i) == '+') {
            sign = 1;
            i++;
        }

        while (i < len && Character.isDigit(str.charAt(i))) {
            res = res * 10 + str.charAt(i) - '0';
            if (sign * res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return sign * (int) res;
    }
}
