package googleti;

/* Campus bikes */

import java.util.*;

public class L1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers.length == 0 || bikes.length == 0) {
            return new int[0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { // o1[0] is bike idx, o1[1] is worker idx, o1[2] is distance
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int numWorkers = workers.length;
        int numBikes = bikes.length;
        for (int i = 0; i < numBikes; i++) {
            for (int j = 0; j < numWorkers; j++) {
                int dist = Math.abs(bikes[i][0] - workers[j][0]) + Math.abs(bikes[i][1] - workers[j][1]);
                pq.offer(new int[] {i, j, dist});
            }
        }

        int[] res = new int[numWorkers];
        Arrays.fill(res, -1);
        Set<Integer> takenBike = new HashSet<>();
        while (!pq.isEmpty() && takenBike.size() < numWorkers) {
            int[] ele = pq.poll();
            if (res[ele[1]] == -1 && takenBike.add(ele[0])) {
                res[ele[1]] = ele[0];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] workers = {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 2}};
        int[][] bikes = {{1, 1}};

        L1057 test = new L1057();
        test.assignBikes(workers, bikes);
    }
}
