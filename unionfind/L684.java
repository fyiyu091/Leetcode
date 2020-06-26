package unionfind;

/* Find the redundant edge to make the undirected graph (tree-like) fail */

public class L684 {
    class UnionFind {
        int[] parent;
        int[] size;

        UnionFind(int N) {
            parent = new int[N + 1];
            size = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int v, int u) {
            int vRoot = findRoot(v);
            int uRoot = findRoot(u);
            if (size[vRoot] > size[uRoot]) {
                parent[uRoot] = vRoot;
                size[vRoot] += size[uRoot];
            }
            else {
                parent[vRoot] = uRoot;
                size[uRoot] += size[vRoot];
            }
        }

        public boolean find(int v, int u) {
            return findRoot(v) == findRoot(u);
        }

        public int findRoot(int v) {
            int curr = v;
            while (curr != parent[curr]) {
                parent[curr] = parent[parent[curr]];
                curr = parent[curr];
            }
            parent[v] = curr;
            return curr;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }

        UnionFind uf = new UnionFind(edges.length);
        int[] res = new int[2];
        for (int[] edge : edges) {
            if (!uf.find(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
            }
            else {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }

        return res;
    }
}
