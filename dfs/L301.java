package dfs;

/* Remove invalid parentheses */

import java.util.ArrayList;
import java.util.List;

public class L301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }

        int removeL = numberRemove(s)[0];
        int removeR = numberRemove(s)[1];

        dfs(res, new StringBuilder(), s, 0, removeL, removeR, 0);

        return res;
    }

    private void dfs(List<String> res, StringBuilder path, String s, int index, int removeL, int removeR, int delta) {
        if (index == s.length() && removeL == 0 && removeR == 0 && delta == 0) {
            res.add(path.toString());
            return;
        }
        if (index == s.length() || removeL < 0 || removeR < 0 || delta < 0) {
            return;
        }
        if (s.charAt(index) == '(') {
            path.append('(');
            dfs(res, path, s, index + 1, removeL, removeR, delta + 1);
            path.setLength(path.length() - 1);

            // purpose of this check is to dedup
            // before going into the next level, make sure skip the adjacent same parentheses
            while (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
                index++;
                removeL--;
            }
            dfs(res, path, s, index + 1, removeL - 1, removeR, delta);
        }
        else if (s.charAt(index) == ')') {
            path.append(')');
            dfs(res, path, s, index + 1, removeL, removeR, delta - 1);
            path.setLength(path.length() - 1);

            while (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
                index++;
                removeR--;
            }
            dfs(res, path, s, index + 1, removeL, removeR - 1, delta);
        }
        else {
            path.append(s.charAt(index));
            dfs(res, path, s, index + 1, removeL, removeR, delta);
            path.setLength(path.length() - 1);
        }
        return;
    }

    /* Function to find minimum left and right removal */
    private int[] numberRemove(String s) {
        char[] arr = s.toCharArray();
        int removeL = 0;
        int removeR = 0;
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                removeL++;
            }
            else if (arr[i] == ')') {
                if (removeL > 0) {
                    removeL--;
                }
                else {
                    removeR++;
                }
            }
        }
        res[0] = removeL;
        res[1] = removeR;
        return res;
    }
}
