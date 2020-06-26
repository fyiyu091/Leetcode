package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Return the boundary of binary tree */

public class L545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        if(isLeaf(root)){
            return result;
        }
        TreeNode cur = root.left;
        while(cur != null && !isLeaf(cur)){
            result.add(cur.val);
            if(cur.left != null){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        cur = root;
        addLeaf(cur, result);

        Stack<TreeNode> stack = new Stack<>();
        cur = root.right;
        while(cur != null && !isLeaf(cur)){
            stack.push(cur);
            if(cur.right != null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop().val);
        }
        return result;
    }

    private void addLeaf(TreeNode cur, List<Integer> result){
        if(cur == null){
            return;
        }
        if(isLeaf(cur)){
            result.add(cur.val);
            return;
        }
        addLeaf(cur.left, result);
        addLeaf(cur.right, result);
    }

    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
