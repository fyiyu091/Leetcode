package graph;

/* Alien dictionary
*  ab
*  adc
*  means b is larger than d and c
*
*  abc
*  ab
*  this case is not valid
* */

import java.util.*;

public class L269 {
    private boolean flag;
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words);
        if (flag) {
            return "";
        }
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

    // First of, solve the char not all included problem
    // All the char of each string will need to be added to the graph
    // The first different element will define the local order
    // Also need prev char point to the next char
    /*
       wrt
       wrf
       er
       ett
       rftt
     */
    private void buildGraph(Map<Character, Set<Character>> graph, String[] words) {
        boolean isValid = false;
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            int prevIdx = 0, currIdx = 0;
            while (prevIdx < prev.length() && currIdx < curr.length()) {
                char ch1 = prev.charAt(prevIdx++);
                char ch2 = curr.charAt(currIdx++);
                if (!graph.containsKey(ch1)) {
                    graph.put(ch1, new HashSet<>());
                }
                if (!graph.containsKey(ch2)) {
                    graph.put(ch2, new HashSet<>());
                }
                if (ch1 != ch2) {
                    graph.get(ch1).add(ch2);
                    isValid = true; // abc, ab case should return ""
                    break;
                }
            }

            while (prevIdx < prev.length()) { // prev haven't finish
                if (!isValid) {
                    flag = true;
                    return;
                }
                if (!graph.containsKey(prev.charAt(prevIdx))) {
                    graph.put(prev.charAt(prevIdx), new HashSet<>());
                }
                prevIdx++;
            }

            while (currIdx < curr.length()) {
                if (!graph.containsKey(curr.charAt(currIdx))) {
                    graph.put(curr.charAt(currIdx), new HashSet<>());
                }
                currIdx++;
            }
            prev = curr;
        }
    }

    public static void main(String[] args) {
        // whether the
    }
}
