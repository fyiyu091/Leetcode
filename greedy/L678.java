package greedy;

/* Check if the parenthesis string is valid
   The string can contains * which can be converted to either empty, ( or )
 */
public class L678 {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int low = 0; // low means at least unmatched (
        int high = 0; // high means at most unmatched (
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                low++;
                high++;
            }
            else if (ch == ')') {
                low--;
                high--;
            }
            else {
                low--;
                high++;
            }
            if (high < 0) break;
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}
