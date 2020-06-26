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
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        if (idx == s.length() || part > 4) {
            return;
        }

        int num = 0;
        int originLen = sb.length();
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            num = num * 10 + Character.getNumericValue(s.charAt(i));
            if (num >= 0 && num <= 255) {
                sb.append(num + ".");
                dfs(res, sb, s, i + 1, part + 1);
                sb.setLength(originLen);
            }
            if (num == 0) {
                break;
            }
        }
    }
}
