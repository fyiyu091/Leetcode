package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
   Find k values in the BST that are closest to the target
 */
public class L272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < target) {
                left.push(curr);
                curr = curr.right;
            }
            else {
                right.push(curr);
                curr = curr.left;
            }
        }

        while (k-- > 0) {
            if (!left.isEmpty() && !right.isEmpty()) {
                if (Math.abs(left.peek().val - target) < Math.abs(right.peek().val - target)) {
                    res.add(0, left.peek().val);
                    moveToLeft(left);
                }
                else {
                    res.add(0, right.peek().val);
                    moveToRight(right);
                }
            }
            else if (!left.isEmpty()) {
                res.add(0, left.peek().val);
                moveToLeft(left);
            }
            else {
                res.add(0, right.peek().val);
                moveToRight(right);
            }
        }

        return res;
    }

    private void moveToLeft(Stack<TreeNode> toLeft) {
        TreeNode curr = toLeft.pop().left;
        while (curr != null) {
            toLeft.push(curr);
            curr = curr.right;
        }
    }

    private void moveToRight(Stack<TreeNode> toRight) {
        TreeNode curr = toRight.pop().right;
        while (curr != null) {
            toRight.push(curr);
            curr = curr.left;
        }
    }
}
