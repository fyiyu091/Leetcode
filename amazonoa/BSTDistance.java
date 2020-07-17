package amazonoa;

import tree.TreeNode;

import java.util.Arrays;
import java.util.List;

/* Using given values to build the tree
   Find LCA of node1 and node2
   The distance will be depth of node1 + depth of node2 - 2 * depth of LCA
 */
public class BSTDistance {
    public static int bstDistance(int num, List<Integer> values, int node1, int node2) {
        if (num <= 0 || values == null || values.size() == 0) {
            return 0;
        }

        TreeNode root = new TreeNode(values.get(0));
        for (int i = 1; i < values.size(); i++) {
            insertElement(root, values.get(i));
        }

        // The tree based on root is built
        TreeNode lca = findLCA(root, node1, node2);
        if (lca == null) {
            return -1;
        }

        int node1Depth = findDepth(root, node1);
        int node2Depth = findDepth(root, node2);
        if (node1Depth == -1 || node2Depth == -1) {
            return -1;
        }
        else {
            return node1Depth + node2Depth - 2 * findDepth(root, lca.val);
        }
    }

    // Find depth in BST
    private static int findDepth(TreeNode root, int val) {
        int res = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val) {
                return res;
            }
            else if (curr.val < val) {
                res++;
                curr = curr.right;
            }
            else {
                res++;
                curr = curr.left;
            }
        }
        return -1;
    }

    // Find LCA in BST
    private static TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null || root.val == node1 || root.val == node2) {
            return root;
        }
        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
    
    private static void insertElement(TreeNode root, int val) {
        TreeNode curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return;
                }
                curr = curr.left;
            }
            if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return;
                }
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10,8,12,7,9,17,18,20,19);
        int num = 9;
        int node1 = 7;
        int node2 = 9;
        System.out.println(bstDistance(num, values, node1, node2));
    }
}
