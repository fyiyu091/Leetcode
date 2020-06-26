package tree;

import java.util.Stack;

public class L653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> moveToLeft = new Stack<>();
        Stack<TreeNode> moveToRight = new Stack<>();
        initLeftStack(root, moveToLeft);
        initRightStack(root, moveToRight);

        while (moveToLeft.peek() != moveToRight.peek()) {
            if (moveToLeft.peek().val + moveToRight.peek().val == k) {
                return true;
            }
            else if (moveToLeft.peek().val + moveToRight.peek().val < k) {
                moveLeft(moveToLeft);
            }
            else {
                moveRight(moveToRight);
            }
        }
        return false;
    }

    private void initLeftStack(TreeNode root, Stack<TreeNode> moveToLeft) {
        TreeNode curr = root;
        while (curr != null) {
            moveToLeft.push(curr);
            curr = curr.left;
        }
    }

    private void initRightStack(TreeNode root, Stack<TreeNode> moveToRight) {
        TreeNode curr = root;
        while (curr != null) {
            moveToRight.push(curr);
            curr = curr.right;
        }
    }

    private void moveLeft(Stack<TreeNode> moveToLeft) {
        TreeNode curr = moveToLeft.pop().right;
        while (curr != null) {
            moveToLeft.push(curr);
            curr = curr.left;
        }
    }

    private void moveRight(Stack<TreeNode> moveToRight) {
        TreeNode curr = moveToRight.pop().left;
        while (curr != null) {
            moveToRight.push(curr);
            curr = curr.right;
        }
    }
}
