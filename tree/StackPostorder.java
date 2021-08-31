package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackPostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode tmp = stack.peek().right;
                // Means that peek's left and right were all visited, we can work on peek
                if (tmp == null) {
                    tmp = stack.pop();
                    res.add(tmp.val);
                    // If the one we just worked on is the right child of the peek, means that we can work on peek
                    while (!stack.isEmpty() && tmp == stack.peek().right) {
                        tmp = stack.pop();
                        res.add(tmp.val);
                    }
                }
                // Right part hasn't get worked on yet, need to work on the right subtree
                else {
                    curr = tmp;
                }
            }
        }

        return res;
    }
}
