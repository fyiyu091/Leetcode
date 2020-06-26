package tree;

/* Given preorder and inorder, construct the binary tree */

import java.util.HashMap;
import java.util.Map;

public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder,0, preorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int idx = map.get(preorder[pStart]);
        root.left = helper(preorder, pStart + 1, pStart + idx - iStart, inorder, iStart, idx - 1, map);
        root.right = helper(preorder, pStart + idx - iStart + 1, pEnd, inorder, idx + 1, iEnd, map);
        return root;
    }
}
