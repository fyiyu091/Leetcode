package unionfind;

/*
   Number of island I
   The board is given and find out how many island
   Using union-find to do the problem, union what? Flat the 2D board union the integer representing island

 */
public class L200 {
    class UnionFind {
        private int[] parents;
        private int[] sizes;

        UnionFind(int n) {
            this.parents = new int[n];
            this.sizes = new int[n];
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (sizes[pRoot] < sizes[qRoot]) {
                parents[pRoot] = qRoot;
                sizes[qRoot] += sizes[pRoot];
            }
            else {
                parents[qRoot] = pRoot;
                sizes[pRoot] += sizes[qRoot];
            }
        }

        public boolean find(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        private int findRoot(int p) {
            int curr = p;
            while (curr != parents[curr]) {
                parents[curr] = parents[parents[curr]];
                curr = parents[curr];
            }
            parents[p] = curr;
            return curr;
        }

        public void addIsland(int idx) {
            parents[idx] = idx;
            sizes[idx] = 1;
        }

        public boolean isIsland(int idx) {
            return sizes[idx] > 0;
        }
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int newIsland = i * col + j;
                    uf.addIsland(newIsland);
                    res++;
                    for (int[] dir : DIRECTIONS) {
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        int nextIsland = ii * col + jj;
                        if (ii >= 0 && ii < row && jj >= 0 && jj < col && grid[ii][jj] == '1' && uf.isIsland(nextIsland)) {
                            if (!uf.find(newIsland, nextIsland)) {
                                uf.union(newIsland, nextIsland);
                                res--;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
