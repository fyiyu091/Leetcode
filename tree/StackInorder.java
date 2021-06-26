package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
    1. Value is being added to the res when poped out of the stack
    2. Adding all the left until null
    3. pop val and move to right
 */
public class StackInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // For adding all the left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Exhausted the left children, time to pop, add and start with the right subtree
            else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }
}
