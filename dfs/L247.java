package dfs;

/* Generate all strobogrammatic number that length == n */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');

        dfs(res, new char[n], 0, n - 1, map);
        return res;
    }

    private void dfs(List<String> res, char[] arr, int start, int end, Map<Character, Character> map) {
        if (start > end) {
            res.add(String.valueOf(arr));
            return;
        }
        if (start == end) {
            for (char ch : map.keySet()) {
                if (ch == '6' || ch == '9') { // Need to consider "161" case, the 6 or 9 shouldn't be in the middle
                    continue;
                }
                arr[start] = ch;
                res.add(String.valueOf(arr));
            }
            return;
        }

        for (char ch : map.keySet()) {
            if (start == 0 && ch == '0') { // Need to consider "00" case
                continue;
            }
            arr[start] = ch;
            arr[end] = map.get(ch);
            dfs(res, arr, start + 1, end - 1, map); // No need to backtracking, because it is arr[idx] overwrite
        }
    }
}
