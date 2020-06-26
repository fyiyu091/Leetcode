package binaryreduction;

/* Return String and to the .01 resolution */
/* times 10000 solution*/

public class MySqrt {
    public String mySqrt(int n) {
        if (n == 0) {
            return "0.00";
        }
        if (n == 1) {
            return "1.00";
        }

        long tmp = n * 10000;
        long left = 0;
        long right = tmp;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (tmp / mid == mid) {
                return convert(mid);
            }
            else if (tmp / mid < mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return convert(right);
    }

    private String convert(long mid) {
        String tmp = String.valueOf(mid);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2; i++) {
            if (i == 1) {
                sb.append('.');
            }
            sb.append(tmp.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MySqrt test = new MySqrt();
        System.err.println(test.mySqrt(19));
    }
}
