package dp;

import java.util.*;

public class L140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (String str : wordDict) {
            dict.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j)) && dp[j] == true) {
                    if (graph.get(i) == null) {
                        graph.put(i, new ArrayList<Integer>());
                    }
                    graph.get(i).add(j);
                    dp[i] = true;
                }
            }
        }

        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), graph, 0, s);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, Map<Integer, List<Integer>> graph, int index, String s) {
        if (index == s.length()) {
            res.add(sb.toString().trim());
            return;
        }

        if (graph.get(index) != null) {
            for (int next : graph.get(index)) {
                int originLen = sb.length();
                sb.append(s.substring(index, next) + " ");
                dfs(res, sb, graph, next, s);
                sb.setLength(originLen);
            }
        }

        return;
    }
}
