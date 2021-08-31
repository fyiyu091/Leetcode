package tree;

import java.util.ArrayList;
import java.util.List;

/*
    For complete binary tree
    The last element would be (size - 1) / 2
        0
      1   2

    0 1 2

    3 - 1 / 2 -> 1

       0
     1    2
   3  4  5

   6 - 1 / 2 -> 2
 */
public class CBTInserter {
    List<TreeNode> tree;
    public CBTInserter(TreeNode root) {
        this.tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).left != null) {
                tree.add(tree.get(i).left);
            }
            if (tree.get(i).right != null) {
                tree.add(tree.get(i).right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        int size = tree.size();
        if (size % 2 == 1) {
            // Why is the size - 1 case here
            // Because when we add one more it would become size
            // And then - 1 would do it
            tree.get((size - 1) / 2).left = node;
        }
        else {
            tree.get((size - 1) / 2).right = node;
        }
        tree.add(node);

        return tree.get((size - 1) / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}
