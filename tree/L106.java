package tree;

import java.util.HashMap;
import java.util.Map;

public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(postorder[postEnd]);
        root.left = build(inorder, inStart, idx - 1, postorder, postStart, postStart + idx - inStart - 1, map);
        root.right = build(inorder, idx + 1, inEnd, postorder, postEnd - inEnd + idx, postEnd - 1, map);
        return root;
    }
}
