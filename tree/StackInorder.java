package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
    1. Value is being added to the res when poped out of the stack
    2. Adding all the left until null
    3. pop val and move to right
 */
public class StackInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return res;
        }

        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            TreeNode next = stack.pop();
            res.add(next.val);
            TreeNode nextSubtree = next.right;
            while (nextSubtree != null) {
                stack.push(nextSubtree);
                nextSubtree = nextSubtree.left;
            }
        }

        return res;
    }
}
