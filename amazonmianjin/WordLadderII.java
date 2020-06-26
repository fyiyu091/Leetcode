package amazonmianjin;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> graph = new HashMap<>();
        queue.offer(beginWord);
        dict.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> lvlRemove = new HashSet<>();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    dfs(res, graph, curr, beginWord, new ArrayList<>());
                    return res;
                }
                char[] arr = curr.toCharArray();
                for (int i = 0; i < curr.length(); i++) {
                    char origin = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String tmpStr = String.valueOf(arr);
                        if (!tmpStr.equals(curr) && dict.contains(tmpStr)) {
                            if (!graph.containsKey(tmpStr)) {
                                graph.put(tmpStr, new LinkedList<>());
                                queue.offer(tmpStr);
                                lvlRemove.add(tmpStr);
                            }
                            graph.get(tmpStr).add(curr);
                        }
                    }
                    arr[i] = origin;
                }
            }
            dict.removeAll(lvlRemove);
        }
        return res;
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> graph, String curr, String beginWord, List<String> path) {
        if (curr.equals(beginWord)) {
            path.add(0, curr);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }

        path.add(0, curr);
        for (String str : graph.get(curr)) {
            dfs(res, graph, str, beginWord, path);
        }
        path.remove(0);

        return;
    }
}
