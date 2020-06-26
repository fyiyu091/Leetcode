package tree;

/* Maximum width of binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class L662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> numQ = new LinkedList<>();
        int max = 0;
        nodeQ.offer(root);
        numQ.offer(0);
        while (!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                int tmpNum = numQ.poll();
                TreeNode tmpNode = nodeQ.poll();
                if (i == 0) {
                    start = tmpNum;
                }
                if (i == size - 1) {
                    end = tmpNum;
                }
                if (tmpNode.left != null) {
                    nodeQ.offer(tmpNode.left);
                    numQ.offer(tmpNum * 2);
                }
                if (tmpNode.right != null) {
                    nodeQ.offer(tmpNode.right);
                    numQ.offer(tmpNum * 2 + 1);
                }
            }
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
