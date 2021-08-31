package dfs;

public class L375 {
    public int getMoneyAmount(int n) {
        return dfs(n, 1, n);
    }

    // Return the minimum amount of money needed
    private int dfs(int n, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int tmp = i + Math.max(dfs(n, left, i - 1), dfs(n, i + 1, right));
            res = Math.min(res, tmp);
        }

        return res;
    }
}
