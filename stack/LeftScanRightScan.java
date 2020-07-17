package stack;

/*
   Minimum deletion to make an invalid parentheses valid
   (()))()(( -> (())()
   Scan from left delete )
   Scan from right delete (
 */
public class LeftScanRightScan {
    public static String makeParenthesesValid(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int delta = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                delta++;
                sb.append(ch);
            }
            else {
                if (delta == 0) {
                    continue;
                }
                else {
                    delta--;
                    sb.append(ch);
                }
            }
        }

        String tmp = sb.toString();
        sb = new StringBuilder();
        delta = 0;
        for (int i = tmp.length() - 1; i >= 0; i--) {
            char ch = tmp.charAt(i);
            if (ch == ')') {
                delta++;
                sb.append(ch);
            }
            else {
                if (delta == 0) {
                    continue;
                }
                else {
                    delta--;
                    sb.append(ch);
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "((())))()()((";
        String input1 = "((())()((";
        String input2 = "(()))()()((";
        String input3 = "((";
        String input4 = "))()(";
        System.out.println(makeParenthesesValid(input));
        System.out.println(makeParenthesesValid(input1));
        System.out.println(makeParenthesesValid(input2));
        System.out.println(makeParenthesesValid(input3));
        System.out.println(makeParenthesesValid(input4));
    }
}
