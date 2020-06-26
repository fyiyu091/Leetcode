package dp;

/* Only need to get just one path of the word break */

import java.util.*;

public class wordBreakIII {
    public String wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        Map<Integer, Integer> graph = new HashMap<>();
        for (String str : wordDict) {
            dict.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j)) && dp[j] == true) {
                    graph.put(i, j);
                    dp[i] = true;
                }
            }
        }

        String res = generateRes(graph, s);
        return res;
    }

    private String generateRes(Map<Integer, Integer> graph, String s) {
        String res = "";
        int index = 0;
        while (graph.get(index) != null) {
            res += s.substring(index, graph.get(index)) + " ";
            index = graph.get(index);
        }
        return res.trim();
    }

    public static void main(String[] args) {
        wordBreakIII test = new wordBreakIII();
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        System.out.println(test.wordBreak(s, wordDict));
    }
}
