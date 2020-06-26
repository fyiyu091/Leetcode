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
                if (tmp == null) {
                    tmp = stack.pop();
                    res.add(tmp.val);
                    while (!stack.isEmpty() && tmp == stack.peek().right) {
                        tmp = stack.pop();
                        res.add(tmp.val);
                    }
                }
                else {
                    curr = tmp;
                }
            }
        }

        return res;
    }
}
