package string;

/* Find the minimum number of parentheses needed to make the string valid */
/* ()))(( case is important, basically when we have more ), add to offset that */

public class L921 {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int delta = 0;
        int left = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                delta++;
            }
            else {
                delta--;
            }
            if (delta == -1) {
                left++;
                delta = 0;
            }
        }

        return left + delta;
    }
}
