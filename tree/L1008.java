package tree;

/* Construct binary search tree from preorder traversal */

public class L1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertNode(root, preorder[i]);
        }

        return root;
    }

    private TreeNode insertNode(TreeNode root, int num) {
        if (root == null) {
            root = new TreeNode(num);
            return root;
        }

        if (root.val > num) {
            root.left = insertNode(root.left, num);
        }
        else {
            root.right = insertNode(root.right, num);
        }
        return root;
    }
}
