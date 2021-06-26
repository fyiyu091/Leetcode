package dfs;

/* Restore IP Address */

import java.util.ArrayList;
import java.util.List;

public class L93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }

        dfs(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String s, int idx, int part) {
        if (idx == s.length() && part == 4) {
            // . will be added when add fourth part, will need to truncate it before add to result
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        if (idx == s.length() || part > 4) {
            return;
        }

        // Starts with num = 0, however it would ge changed with the num assignment statement below
        int num = 0;
        int originLen = sb.length();
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            num = num * 10 + Character.getNumericValue(s.charAt(i));
            if (num >= 0 && num <= 255) {
                sb.append(num + ".");
                dfs(res, sb, s, i + 1, part + 1);
                // Set the size back after a .
                sb.setLength(originLen);
            }
            // Prevent 01.XXX this kind of case
            if (num == 0) {
                break;
            }
        }
    }
}
