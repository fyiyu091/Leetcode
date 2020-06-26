package bfs;

/* Open the lock */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L752 {
    public static final char[][] CONVERT = {{'9', '1'}, {'0', '2'}, {'1', '3'}, {'2', '4'}, {'3', '5'}, {'4', '6'}, {'5', '7'}, {'6', '8'}, {'7', '9'}, {'8', '0'}};
    public int openLock(String[] deadends, String target) {
        // corner case
        Set<String> deadSet = new HashSet<>();
        for (String str : deadends) {
            deadSet.add(str);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        if (!deadSet.contains("0000")) {
            queue.offer("0000");
            visited.add("0000");
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (target.equals(curr)) {
                    return res;
                }
                char[] charArr = curr.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char origin = charArr[i];
                    for (int j = 0; j < 2; j++) {
                        charArr[i] = CONVERT[Integer.parseInt(String.valueOf(origin))][j];
                        String tmp = String.valueOf(charArr);
                        if (!deadSet.contains(tmp) && visited.add(tmp)) {
                            queue.offer(tmp);
                        }
                    }
                    charArr[i] = origin;
                }
            }
            res++;
        }
        return -1;
    }
}
