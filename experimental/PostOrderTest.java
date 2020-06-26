package experimental;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTest {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek().right;
            if (tmp == null) {
                tmp = stack.pop();
                res.add(tmp.val);
            }
            else {
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PostOrderTest test = new PostOrderTest();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.right = two;
        two.left = three;

        test.postorderTraversal(root);
    }
}
