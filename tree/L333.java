package tree;

/* Find the largest subtree which is BST */

public class L333 {
    private int max = 0;
    class Node {
        int max;
        int min;
        int size;
        public Node(int min, int max, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return max;
    }

    private Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(0, 0, 0);
        }

        Node left = dfs(root.left);
        Node right = dfs(root.right);
        // null means that this tree is not BST
        // if left child or right child is not BST, the root is not BST for sure
        if (left == null || right == null) {
            return null;
        }
        // Using root.size == 0 to check if the root is null
        if ((left.size == 0 || left.max < root.val) && (right.size == 0 || right.min > root.val)) {
            max = Math.max(max, left.size + right.size + 1);
            int retMin = left.size == 0 ? root.val : left.min;
            int retMax = right.size == 0 ? root.val : right.max;
            return new Node(retMin, retMax, left.size + right.size + 1);
        }
        else {
            return null;
        }
    }
}
