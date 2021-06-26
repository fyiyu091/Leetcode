package array;

/*
    Replace ? to any char to make the string doesn't have adjacent equal character
    Can only select from a b c
 */
public class L1576 {
    public String modifyString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        char[] res = s.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if (i > 0 && res[i - 1] == c) continue; // If is the char at index 0, will skip this line
                    if (i < res.length - 1 && res[i + 1] == c) continue; // If is the char at length - 1, will skip this line
                    res[i] = c;
                    break;
                }
            }
        }

        return String.valueOf(res);
    }
}
