package graph;

/* Use union find to check if can construct a tree */

public class L261 {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || n != edges.length + 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];

            // Each time there was no merge, it was because we were adding an edge between two nodes that were already
            // connected via a path. This means there is now an additional path between them -> definition of a cycle
            if (uf.find(p, q)) {
                return false;
            }
            else {
                uf.union(p, q);
            }
        }
        return uf.getComponents() == 1;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int components;

        UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            this.components = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        boolean find(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (size[pRoot] < size[qRoot]) {
                parents[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            else {
                parents[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
            components--;
        }

        private int findRoot(int p) {
            int curr = p;
            while (parents[curr] != curr) {
                parents[curr] = parents[parents[curr]];
                curr = parents[curr];
            }
            parents[p] = curr;
            return curr;
        }

        public int getComponents() {
            return this.components;
        }
    }
}
