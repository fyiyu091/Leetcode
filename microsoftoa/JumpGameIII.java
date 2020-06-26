package microsoftoa;

/* Leetcode 1306 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        // visited store the visited index of arr
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int currIdx = queue.poll();
            if (arr[currIdx] == 0) {
                return true;
            }
            int jumpBack = currIdx - arr[currIdx];
            if (jumpBack >= 0 && visited.add(jumpBack)) {
                queue.offer(jumpBack);
            }
            int jumpForward= currIdx + arr[currIdx];
            if (jumpForward < len && visited.add(jumpForward)) {
                queue.offer(jumpForward);
            }
        }

        return false;
    }
}
