package graph;

/* Alien dictionary */

import java.util.*;

public class L269 { //TODO, have bug, ["ab", "adc"] case failed, can use boolean matrix to representing graph
    public String alienOrder(String[] words) {
        if (words == null || words.length <= 1) {
            return "";
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words);
        Map<Character, Integer> status = new HashMap<>();
        for (Character ch: graph.keySet()) {
            status.put(ch, 0);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : graph.keySet()) {
            if (dfs(ch, graph, status, sb)) {
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(Character curr, Map<Character, Set<Character>> graph, Map<Character, Integer> status, StringBuilder sb) {
        if (status.get(curr) == 2) {
            return false;
        }
        if (status.get(curr) == 1) {
            return true;
        }

        status.put(curr, 1);
        for (Character next : graph.get(curr)) {
            if (dfs(next, graph, status, sb)) {
                return true;
            }
        }

        sb.append(curr);
        status.put(curr, 2);
        return false;
    }

    private void buildGraph(Map<Character, Set<Character>> graph, String[] words) {
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while (j < words[i - 1].length() && j < words[i].length()) {
                if (!graph.containsKey(words[i - 1].charAt(j))) {
                    graph.put(words[i - 1].charAt(j), new HashSet<>());
                }
                if (words[i - 1].charAt(j) != words[i].charAt(j)) {
                    if (graph.get(words[i - 1].charAt(j)) == null) {
                        graph.put(words[i - 1].charAt(j), new HashSet<>());
                    }
                    graph.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
                    if (!graph.containsKey(words[i].charAt(j))) {
                        graph.put(words[i].charAt(j), new HashSet<>());
                    }
                    break;
                }
                j++;
            }
        }
    }
}
