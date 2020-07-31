package stack;

/* Return any valid string
   lee(t(c)o)de) -> lee(t(c)o)de
 */
public class L1249 {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int delta = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                sb.append(ch);
                delta++;
            }
            else if (ch == ')') {
                if (delta == 0) {
                    continue;
                }
                else {
                    sb.append(ch);
                    delta--;
                }
            }
            else {
                sb.append(ch);
            }
        }

        String tmp = sb.toString();
        len = tmp.length();
        sb = new StringBuilder();
        delta = 0;
        for (int i = len - 1; i >= 0; i--) {
            char ch = tmp.charAt(i);
            if (ch == ')') {
                sb.append(ch);
                delta++;
            }
            else if (ch == '(') {
                if (delta == 0) {
                    continue;
                }
                else {
                    sb.append(ch);
                    delta--;
                }
            }
            else {
                sb.append(ch);
            }
        }

        return sb.reverse().toString();
    }
}
