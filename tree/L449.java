package tree;

/* Serialize and deserialize BST */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    /*
        This is the function to preorder traverse the
        tree
        @param root this is the root TreeNode
        @param sb this is the sb to store
        @return void
     */
    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
        return;
    }

    // Decodes your encoded data to tree.
    // Now we have preorder of the tree, sort it we can get inorder then construct the tree
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] strs = data.split(",");
        int[] inorder = new int[strs.length];
        int[] preorder = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            inorder[i] = Integer.valueOf(strs[i]);
            preorder[i] = Integer.valueOf(strs[i]);
        }

        Arrays.sort(inorder);

        return construct(preorder, inorder);
    }

    private TreeNode construct(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int len = preorder.length;

        return helper(preorder, 0, len - 1, inorder, 0, len - 1, map);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (pStart > pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int idx = map.get(preorder[pStart]);
        root.left = helper(preorder, pStart + 1, pStart + idx - iStart, inorder, iStart, idx - 1, map);
        root.right = helper(preorder, pStart + idx - iStart + 1, pEnd, inorder, idx + 1, iEnd, map);
        return root;
    }
}
