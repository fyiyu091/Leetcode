package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    1. Whenever the TreeNode is poped from the stack, add it to the res
    2. Push right child before left child, as the left would poped out first
 */
public class StackPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return res;
    }
}
