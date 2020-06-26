package binaryreduction;

public class L69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            else if (x / mid > mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        throw new RuntimeException("Should be here");
    }

    public static void main(String[] args) {
        L69 test = new L69();
        System.err.println(test.mySqrt(1));
    }
}
