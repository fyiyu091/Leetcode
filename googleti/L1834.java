package googleti;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1834 {
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        int[][] idxTasks = new int[len][3];

        for (int i = 0; i < len; i++) {
            idxTasks[i][0] = tasks[i][0];
            idxTasks[i][1] = tasks[i][1];
            idxTasks[i][2] = i;
        }
        Arrays.sort(idxTasks, (a, b) -> a[0] - b[0]);

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int time = 0;
        int[] res = new int[len];
        // This idx is used to adding the task to the queue based on enqueueTime
        int idx = 0;


        for (int i = 0; i < len; i++) {
            // If the queue is empty, need to find the next available item
            if (queue.isEmpty()) {
                time = Math.max(time, idxTasks[idx][0]);
            }
            while (idx < len && idxTasks[idx][0] <= time) {
                queue.offer(idxTasks[idx++]);
            }
            int[] task = queue.poll();
            res[i] = task[2];
            time += task[1];
        }

        return res;
    }
}
