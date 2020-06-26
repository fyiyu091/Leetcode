package miscellaneous;

public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        int slow = n;
        int fast = nextNum(n);
        while (fast != 1 && fast != slow) {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        }
        return fast == 1;
    }

    private int nextNum(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }
}
