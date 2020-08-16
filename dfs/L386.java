package dfs;

import java.util.ArrayList;
import java.util.List;

/*
      1
   10 ... 19
  100 101

  preorder traverse N-ary tree
 */

public class L386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        for (int i = 1; i <= 9; i++) {
            dfs(res, n, i);
        }

        return res;
    }

    private void dfs(List<Integer> res, int n, int curr) {
        if (curr > n) {
            return;
        }

        res.add(curr);
        for (int i = 0; i <= 9; i++) {
            dfs(res, n, curr * 10 + i);
        }
    }
}
