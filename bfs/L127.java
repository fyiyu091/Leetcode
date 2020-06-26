package bfs;

/* Word ladder, find the minimum transformation from beginWord to endWord */

import java.util.*;

public class L127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);
        // Need to clarify how the res is calculated
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return res;
                }
                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char origin = arr[i];
                    for (char tmp = 'a'; tmp <= 'z'; tmp++) {
                        arr[i] = tmp;
                        // PLEASE!!! Convert char array to String using String.valueOf() instead of toString
                        String tmpStr = String.valueOf(arr);
                        if (dict.contains(tmpStr) && !tmpStr.equals(curr)) {
                            queue.offer(tmpStr);
                            dict.remove(tmpStr);
                        }
                    }
                    arr[i] = origin;
                }
            }
            res++;
        }
        return 0;
    }
}
