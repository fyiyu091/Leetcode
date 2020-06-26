package string;

/* Remove all adjacent duplicates in string
*  "abbaca" -> "ca"
* */

public class L1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (sb.length() == 0) {
                sb.append(S.charAt(i));
            }
            else {
                if (S.charAt(i) == sb.charAt(sb.length() - 1)) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                else {
                    sb.append(S.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
