package dfs;

import java.util.List;

public class L1239 {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        int[] res = new int[1];
        dfs(arr, 0, new StringBuilder(), res);
        return res[0];
    }

    private void dfs(List<String> arr, int currIdx, StringBuilder sb, int[] res) {
        if (currIdx == arr.size()) {
            return;
        }

        int originLen = sb.length();
        for (int i = currIdx; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (!containsDup(sb)) {
                res[0] = Math.max(res[0], sb.length());
                dfs(arr, i + 1, sb, res);
            }
            sb.setLength(originLen);
        }

    }

    private boolean containsDup(StringBuilder sb) {
        if (sb.length() == 0) {
            return false;
        }

        boolean[] contains = new boolean[26];
        for (int i = 0; i < sb.length(); i++) {
            if (contains[sb.charAt(i) - 'a']) {
                return true;
            }
            contains[sb.charAt(i) - 'a'] = true;
        }

        return false;
    }
}
