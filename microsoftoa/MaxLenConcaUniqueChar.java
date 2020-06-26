package microsoftoa;

import java.util.Arrays;
import java.util.List;

public class MaxLenConcaUniqueChar {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        int[] res = new int[1];
        dfs(arr, new StringBuilder(), 0, res);
        return res[0];
    }

    private void dfs(List<String> arr, StringBuilder sb, int idx, int[] res) {
        if (idx == arr.size()) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            int originLen = sb.length();
            sb.append(arr.get(i));
            if (!containsDup(sb)) {
                // The set max shouldn't affect whether calling dfs layer down
                res[0] = Math.max(res[0], sb.length());
                dfs(arr, sb, i + 1, res);
            }
            sb.setLength(originLen);
        }

        return;
    }

    private boolean containsDup(StringBuilder sb) {
        int mask = 0;
        for (int i = 0; i < sb.length(); i++) {
            if ((mask & 1 << (sb.charAt(i) - 'a')) != 0) {
                return true;
            }
            mask |= 1 << (sb.charAt(i) - 'a');
        }
        return false;
    }
}
