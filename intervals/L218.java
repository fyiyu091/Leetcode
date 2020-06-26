package intervals;

/* The skyline problem */
/* Using TreeSet to decrease the remove complexity from maxHeap's O(n) to O(lgn) */

import java.util.*;

public class L218 {
    class Point implements Comparable<Point> {
        int x, height;
        boolean isStart;
        int idx;

        Point(int x, int height, boolean isStart, int idx) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point that) {
            if (this.x != that.x) {
                return this.x - that.x;
            }
            if (this.isStart && that.isStart) {
                return that.height - this.height;
            }
            if (!this.isStart && !that.isStart) {
                return this.height - that.height;
            }
            return that.isStart == true ? 1 : -1;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) {
            return res;
        }

        List<Point> allPoints = new ArrayList<>();
        List<Point> allHeights = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            allPoints.add(new Point(buildings[i][0], buildings[i][2], true, i));
            allPoints.add(new Point(buildings[i][1], buildings[i][2], false, i));
            allHeights.add(new Point(buildings[i][0], buildings[i][2], true, i));
        }

        Collections.sort(allPoints);

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (allHeights.get(o1).height != allHeights.get(o2).height) {
                    return allHeights.get(o2).height - allHeights.get(o1).height;
                }
                else {
                    return o1 - o2;
                }
            }
        };

        // TreeSet stores the unique index
        TreeSet<Integer> maxHeap = new TreeSet<>(comp);
        for (Point pt : allPoints) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(pt.idx);
                res.add(Arrays.asList(pt.x, pt.height));
            }
            else if (pt.isStart) {
                if (pt.height > allHeights.get(maxHeap.first()).height) {
                    res.add(Arrays.asList(pt.x, pt.height));
                }
                maxHeap.add(pt.idx);
            }
            else {
                maxHeap.remove(pt.idx);
                // when to add to heap?
                // when the max height after remove is smaller than the remove one or maxHeap becomes empty
                if (maxHeap.isEmpty() || allHeights.get(maxHeap.first()).height < pt.height) {
                    res.add(Arrays.asList(pt.x, maxHeap.isEmpty() ? 0 : allHeights.get(maxHeap.first()).height));
                }
            }
        }
        return res;
    }
}
