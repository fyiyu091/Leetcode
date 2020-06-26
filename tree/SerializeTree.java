package tree;

/* Using DFS, preOrder traverse the tree */

public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        int[] idx = new int[1];
        String[] strs = data.split(",");
        return helper(strs, idx);
    }

    private TreeNode helper(String[] strs, int[] idx) {
        if (strs[idx[0]].equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(strs[idx[0]]));
        idx[0]++;
        node.left = helper(strs, idx);
        idx[0]++;
        node.right = helper(strs, idx);
        return node;
    }
}
