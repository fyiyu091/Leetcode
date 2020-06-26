package unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Number of island II */

public class L305 {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    class V {
        private V parent;
        private int size;

        V() {
            this.parent = this;
            this.size = 1;
        }
    }

    class UnionFind {
        private V getRoot(V v) {
            V curr = v;
            while (curr.parent != curr) {
                curr.parent = curr.parent.parent;
                curr = curr.parent;
            }
            v.parent = curr;
            return curr;
        }

        public boolean find(V v, V u) {
            return getRoot(v) == getRoot(u);
        }

        public void union(V v, V u) {
            V vRoot = getRoot(v);
            V uRoot = getRoot(u);
            if (vRoot.size < uRoot.size) {
                vRoot.parent = uRoot;
                uRoot.size += vRoot.size;
            }
            else {
                uRoot.parent = vRoot;
                vRoot.size += uRoot.size;
            }
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return res;
        }

        UnionFind uf = new UnionFind();
        Map<Integer, V> map = new HashMap<>();
        int count = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int val = x * n + y;
            if (map.containsKey(val)) {
                res.add(count);
                continue;
            }
            V newV = new V();
            map.put(val, newV);
            count++;
            for (int[] dir : DIRECTIONS) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && map.containsKey(xx * n + yy)) {
                    V neiV = map.get(xx * n + yy);
                    if (!uf.find(neiV, newV)) {
                        uf.union(neiV, newV);
                        count--;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }
}
