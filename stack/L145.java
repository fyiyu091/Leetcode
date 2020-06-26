package stack;

/* use stack to do postorder traversal iteratively */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        stack.push(curr);

        while (!stack.isEmpty()) {
            // prev is the parent of curr
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                else if (curr.right != null) {
                    stack.push(curr.right);
                }
                // curr is leaf node
                else {
                    res.add(stack.pop().val);
                }
            }
            // prev is left child of curr
            else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                else {
                    res.add(stack.pop().val);
                }
            }
            // prev is right child of curr
            else {
                res.add(stack.pop().val);
            }
            prev = curr;
        }
        return res;
    }
}
