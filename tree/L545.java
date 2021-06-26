package tree;

import java.util.ArrayList;
import java.util.List;

/* Return the boundary of binary tree */

public class L545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        if(isLeaf(root)){  // If the root is leaf just return the result
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

        cur = root.right;
        addRight(result, cur);

        return result;
    }

    private void addLeaf(TreeNode cur, List<Integer> result){
        if(cur == null){
            return;
        }

        addLeaf(cur.left, result);
        addLeaf(cur.right, result);
        if(isLeaf(cur)){
            result.add(cur.val);
            return;
        }
    }

    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private void addRight(List<Integer> result, TreeNode curr) {
        if (curr == null || isLeaf(curr)) {
            return;
        }

        if (curr.right != null) {
            addRight(result, curr.right);
        }
        else {
            addRight(result, curr.left);
        }
        result.add(curr.val);
    }
}
