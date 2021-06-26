package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
     Time needed to inform all employees
     Build a tree structure, find the deepest TreeNode with the longest informTime
 */
public class L1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || manager.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> tree = new HashMap<>();
        buildTree(manager, tree);

        int[] res = new int[1];
        int start = 0;
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                start = i;
            }
        }
        dfs(tree, informTime, res, 0, start);
        return res[0];
    }

    private void buildTree(int[] manager, Map<Integer, List<Integer>> tree) {
        for (int i = 0; i < manager.length; i++) {
            if (!tree.containsKey(manager[i])) {
                tree.put(manager[i], new ArrayList<>());
            }
            tree.get(manager[i]).add(i);
        }
    }

    private void dfs(Map<Integer, List<Integer>> tree, int[] informTime, int[] res, int currTime, int currNode) {
        if (tree.get(currNode) == null) {
            res[0] = Math.max(res[0], currTime);
            return;
        }

        for (int next : tree.get(currNode)) {
            dfs(tree, informTime, res, currTime + informTime[currNode], next);
        }
    }
}
