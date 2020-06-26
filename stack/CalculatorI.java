package stack;

/*
   Contains only space, digit, + and -
   E.g. 1 + 25 - 5 = 21
   Evaluate this expression
 */

public class CalculatorI {
    public int eval(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int res = 0;
        int opr = 1;
        int len = str.length();
        int i = 0;
        while (i < len) {
            char ch = str.charAt(i);
            if (ch == ' ') {
            }
            else if (ch == '-') {
                opr = -1;
            }
            else if (ch == '+') {
                opr = 1;
            }
            else if (ch >= '0' && ch <= '9') {
                int num = 0;
                while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    num = num * 10 + Character.getNumericValue(str.charAt(i));
                    i++;
                }
                res += opr * num;
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
        CalculatorI tester = new CalculatorI();
        System.out.println(tester.eval("1 + 25 - 5"));
        System.out.println(tester.eval("1"));
        System.out.println(tester.eval(""));
        System.out.println(tester.eval("-1 +  252 -   5"));
    }
}
