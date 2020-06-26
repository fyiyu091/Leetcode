package dfs;

/* Palindrome partitioning */

import java.util.ArrayList;
import java.util.List;

public class L131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, String s, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            if (isPan(s.substring(idx, i))) {
                path.add(s.substring(idx, i));
                dfs(res, path, s, i);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPan(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
