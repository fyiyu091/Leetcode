package tree;

/* Insert into a binary search tree */

public class L701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            return newNode;
        }

        TreeNode curr = root;
        while (true) {
            if (curr.val < val) {
                if (curr.right == null) {
                    curr.right = newNode;
                    return root;
                }
                else {
                    curr = curr.right;
                }
            }
            else {
                if (curr.left == null) {
                    curr.left = newNode;
                    return root;
                }
                else {
                    curr = curr.left;
                }
            }
        }
    }
}
