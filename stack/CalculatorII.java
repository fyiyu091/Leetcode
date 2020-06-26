package stack;

/* Contains only digit, +, -, *, space
   1 + 3 * 5 - 6 = 10
   3 + 2 * 2 * 2 - 1 = 10
 */

public class CalculatorII {
    public int eval(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // keep prev value
        // if is - or + curr number is the next prev val
        // if is *, prev * curr is the next prev val
        int res = 0;
        int prev = 0;
        int i = 0;
        int opr = 1;
        int len = str.length();

        while (i < len) {
            char ch = str.charAt(i);
            if (ch == ' ') {}
            else if (ch == '+') {
                opr = 1;
            }
            else if (ch == '-') {
                opr = -1;
            }
            else if (ch == '*') {
                opr = 2;
            }
            else if (ch == '/') {
                opr = 3;
            }
            else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < len && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(str.charAt(i));
                    i++;
                }
                if (opr == 2) {
                    res = res - prev + prev * num;
                    prev = prev * num;
                }
                else if (opr == 3) {
                    res = res - prev + prev / num;
                    prev = prev / num;
                }
                else {
                    prev = opr * num;
                    res += prev;
                }
                continue;
            }
            else {
                throw new IllegalArgumentException();
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        CalculatorII tester = new CalculatorII();
        System.out.println(tester.eval("1 + 6 / 2 - 6"));
        System.out.println(tester.eval("1"));
        System.out.println(tester.eval(""));
        System.out.println(tester.eval("3 + 2 * 2 * 2 - 1"));
    }
}
