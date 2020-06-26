package bst;

import java.util.ArrayList;
import java.util.List;

/* Count of smaller numbers after self
*  [5,2,6,1] -> [2,1,1,0]
*/

public class L315 {
    class Node {
        private int val;
        private Node left, right;
        private int rank; // how many is smaller than me
        private int count;

        Node(int val) { // new Node, the rank is always 0, left subtree count is always 0
            this.val = val;
            this.rank = rank;
            this.count = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;
        Node root = new Node(nums[len - 1]);
        res.add(0);

        for (int i = len - 2; i >= 0; i--) {
            int val = nums[i];
            int rankVal = insert(root, val);
            res.add(0, rankVal);
        }

        return res;
    }

    private int insert(Node root, int val) {
        Node curr = root;
        int ret = 0;
        while (curr != null) {
            if (val == curr.val) {
                curr.count++;
                ret += curr.rank;
                break;
            }
            else if (val < curr.val) {
                curr.rank++;
                if (curr.left == null) {
                    curr.left = new Node(val);
                    break;
                }
                curr = curr.left;
            }
            else {
                ret += curr.count + curr.rank;
                if (curr.right == null) {
                    curr.right = new Node(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return ret;
    }
}
