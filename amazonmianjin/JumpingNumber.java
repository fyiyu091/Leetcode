package amazonmianjin;

/* Jump number means the adjacent digits in it differ by only 1
   E.g. 10, 321
   All single digits are jump number, best solution is use BFS to convert
   Starting from all single digits
 */

import java.util.ArrayList;
import java.util.List;

public class JumpingNumber {
    public List<Integer> allJumpingNumber(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        for (int i = 0; i <= n; i++) {
            if (isJumpingNumber(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isJumpingNumber(int n) {
        if (n < 0) {
            return false;
        }

        int prev = n % 10;
        int num = n / 10;
        while (num != 0) {
            int tmp = num % 10;
            if (Math.abs(tmp - prev) > 1) {
                return false;
            }
            prev = tmp;
            num /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        JumpingNumber test = new JumpingNumber();
        List<Integer> res = test.allJumpingNumber(25);
        for (int n : res) {
            System.err.println(n);
        }
    }
}
