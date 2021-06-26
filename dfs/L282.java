package dfs;

/* Expression add operators */

import java.util.ArrayList;
import java.util.List;

public class    L282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;

        dfs(res, new StringBuilder(), num, 0, 0, 0, target);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String num, int index, long sum, long preVal, int target) {
        if (index == num.length() && sum == target) {
            res.add(sb.toString());
            return;
        }
        if (index == num.length()) {
            return;
        }

        long val = 0;
        for (int i = index; i < num.length(); i++) {
            int originLen = sb.length();
            val = val * 10 + (num.charAt(i) - '0');
            if (sb.length() == 0) {
                sb.append(val);
                dfs(res, sb, num, i + 1, val, val, target);
                sb.setLength(originLen);
            }
            else {
                sb.append("+" + val);
                // Prev is the current value
                dfs(res, sb, num, i + 1, sum + val, val, target);
                sb.setLength(originLen);

                sb.append("-" + val);
                dfs(res, sb, num, i + 1, sum - val, -val, target);
                sb.setLength(originLen);

                sb.append("*" + val);
                // Prev is the current value * pre value, pre value would including more values if continue with *
                dfs(res, sb, num, i + 1, (sum - preVal) + (val * preVal), val * preVal, target);
                sb.setLength(originLen);
            }
            if (val == 0) break;
        }

        return;
    }
}
