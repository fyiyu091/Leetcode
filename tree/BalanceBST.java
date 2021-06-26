package tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        // Use extra space to store the sorted values from the BST
        convertToList(root, list);
        // Build the balanced BST from the sorted list
        return buildBST(list, 0, list.size() - 1);

    }

    private void convertToList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        convertToList(root.left, list);
        list.add(root.val);
        convertToList(root.right, list);
        return;
    }

    private TreeNode buildBST(List<Integer> list, int left, int right) {
        if (list == null || left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBST(list, left, mid - 1);
        node.right = buildBST(list, mid + 1, right);
        return node;
    }
}
