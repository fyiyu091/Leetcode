package amazonmianjin;

import java.util.*;

/* No dictionary, therefore we will need to use a HashSet to dedup */

public class WordLadderOnePath {
    public List<String> findLadders(String beginWord, String endWord) {
        List<String> res = new ArrayList<>();

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        Map<String, String> graph = new HashMap<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                char[] arr = curr.toCharArray();
                for (int i = 0; i < curr.length(); i++) {
                    char origin = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String tmpStr = String.valueOf(arr);
                        if (!tmpStr.equals(curr) && visited.add(tmpStr)) {
                            graph.put(tmpStr, curr);
                            if (tmpStr.equals(endWord)) {
                                String tmp = endWord;
                                while (tmp != null) {
                                    res.add(0, tmp);
                                    tmp = graph.get(tmp);
                                }
                            }
                            queue.offer(tmpStr);
                        }
                    }
                    arr[i] = origin;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "0000000001";
        System.err.println(Integer.parseInt(str, 2));
    }
}
