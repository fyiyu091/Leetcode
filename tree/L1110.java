package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    All tree nodes have different values
    Return the roots of the trees in the remaining forest after delete all the to_delete nodes

    Core is that add left(if not null) or right(if not null) to res if deleting curr node
    We need to return the roots of the trees, so we will have to have the tree to be ready
    Then we should do it from bottom to up, we just need to worry about curr level
    Because the bottom up process

            1
          2   3   delete 2, when bottom up to 2, add 4 and 5 to res, return null to 1, finally, add 1 to res
         4 5 7 8

       4, 5, 1
              3
             7 8
 */

public class L1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }

        helper(root, res, set);
        if (!set.contains(root.val)) { // Check if root need to be deleted, if not add root to res
            res.add(root);
        }

        return res;
    }

    private TreeNode helper(TreeNode curr, List<TreeNode> res, Set<Integer> delete) {
        if (curr == null) {
            return null;
        }

        curr.left = helper(curr.left, res, delete);
        curr.right = helper(curr.right, res, delete);

        if (delete.contains(curr.val)) {
            if (curr.left != null) {
                res.add(curr.left);
            }
            if (curr.right != null) {
                res.add(curr.right);
            }
            curr = null;
        }

        return curr;
    }
}
