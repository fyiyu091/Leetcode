package microsoftoa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        Queue<Integer> minHeap = new PriorityQueue<>();
        int room = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
            room = Math.max(room, minHeap.size());
        }

        return room;
    }
}
