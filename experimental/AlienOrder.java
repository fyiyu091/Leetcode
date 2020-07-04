package experimental;

import graph.L269;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlienOrder {
    boolean flag = false;
    public String alienOrder(String[] words) {
        // corner case
        if (words == null || words.length == 0) return "";
        if (words.length == 1) return words[0];

        HashMap<Character, Integer> statuses = new HashMap<>();
        HashMap<Character, List<Character>> graph = buildGraph(words, statuses);
        if (flag) return "";

        StringBuilder path = new StringBuilder();

        for (char start : graph.keySet()) {
            if (containsCycle(start, graph, statuses, path)) {
                return "";
            }
        }
        return path.reverse().toString();
    }

    private HashMap<Character, List<Character>> buildGraph(String[] words, HashMap<Character, Integer> statuses) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            int pre_idx = 0, cur_idx = 0;
            boolean isValid = false;
            while (pre_idx < prev.length() && cur_idx < cur.length()) {
                char c1 = prev.charAt(pre_idx++);
                char c2 = cur.charAt(cur_idx++);
                if (!graph.containsKey(c1)) {
                    graph.put(c1, new ArrayList<>());
                    statuses.put(c1, 0);
                }
                if (!graph.containsKey(c2)) {
                    graph.put(c2, new ArrayList<>());
                    statuses.put(c2, 0);
                }
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    isValid = true;
                    break;
                }
            }
            while (pre_idx < prev.length()) {
                if(!isValid) {
                    flag = true;
                    return graph;
                }
                char c = prev.charAt(pre_idx++);
                if (!graph.containsKey(c)) {
                    graph.put(c, new ArrayList<>());
                    statuses.put(c, 0);
                }
            }
            while (cur_idx < cur.length()) {
                char c = cur.charAt(cur_idx++);
                if (!graph.containsKey(c)) {
                    graph.put(c, new ArrayList<>());
                    statuses.put(c, 0);
                }
            }
            prev = cur;
        }
        return graph;
    }

    private boolean containsCycle(char cur, HashMap<Character, List<Character>> graph,
                                  HashMap<Character, Integer> statuses, StringBuilder path) {
        Integer status = statuses.get(cur);
        if (status == 1) return true;
        if (status == 2) return false;

        statuses.put(cur, 1);
        for (char next : graph.get(cur)) {
            if (containsCycle(next, graph, statuses, path)) {
                return true;
            }
        }
        statuses.put(cur, 2);
        path.append(cur); // 尾巴加，主函数里再reverse
        return false;
    }

    public static void main(String[] args) {
        AlienOrder test = new AlienOrder();
        String[] words = new String[] {"ab", "adc"};
        String[] words1 = new String[] {"wrt","wrf","er","ett","rftt"};
        System.out.println(test.alienOrder(words));
        System.out.println(test.alienOrder(words1));
    }
}
