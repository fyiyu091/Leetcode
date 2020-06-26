package bfs;

import java.util.*;

/* Word Ladder II
return all the shortest transformation sequences
*/

public class L126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();
        boolean found = false;

        for (String str : wordList) {
            dict.add(str);
        }

        queue.add(beginWord);
        dict.remove(beginWord);
        while (!queue.isEmpty()) {
            Set<String> currLevelVisited = new HashSet<>();
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                char[] charArr = curr.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char origin = charArr[i];
                    for (char tmp = 'a'; tmp <= 'z'; tmp++) {
                        charArr[i] = tmp;
                        String tmpStr = String.valueOf(charArr);
                        if (!tmpStr.equals(curr) && dict.contains(tmpStr)) {
                            if (tmpStr.equals(endWord)) {
                                found = true;
                            }
                            // If the word is first time visited
                            if (currLevelVisited.add(tmpStr)) {
                                List<String> strs = new ArrayList<>();
                                strs.add(curr);
                                graph.put(tmpStr, strs);
                                // Only want to add the tmpStr once
                                queue.offer(tmpStr);
                            }
                            // If the word is being visited again
                            else {
                                graph.get(tmpStr).add(curr);
                            }
                        }
                    }
                    charArr[i] = origin;
                }
            }
            // We can only remove the visited word here, because the same level might visit the same word few times
            dict.removeAll(currLevelVisited);

            if (found) {
                List<String> path = new LinkedList<>();
                path.add(0, endWord);
                buildPath(res, path, graph, beginWord, endWord);
                return res;
            }
        }
        return res;
    }

    private void buildPath(List<List<String>> res, List<String> path, Map<String, List<String>> graph, String start, String curr) {
            if (curr.equals(start)) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (String str : graph.get(curr)) {
                path.add(0, str);
                buildPath(res, path, graph, start, str);
                path.remove(0);
            }
            return;
    }

}
