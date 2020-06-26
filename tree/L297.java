package tree;

import java.util.LinkedList;
import java.util.Queue;

public class L297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val + ",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
            else {
                sb.append("#,");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode res = generateNode(arr, 0);
        TreeNode root = res;
        int i = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            curr.left = generateNode(arr, ++i);
            curr.right = generateNode(arr, ++i);
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return res;
    }

    private TreeNode generateNode(String[] arr, int i) {
        if (!arr[i].equals("#")) {
            return new TreeNode(Integer.valueOf(arr[i]));
        }
        else {
            return null;
        }
    }
}
