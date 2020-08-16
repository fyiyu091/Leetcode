package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
   Serialize and deserialize N-ary tree
   Store the # of children node in the String
   So no need to store the null character
                   1
               3   2   4
            5    6
   1,3,3,2,4,2,5,6
                  1
                3 2 4
               5 6
 */
public class L428 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int size = curr.children.size();
            sb.append(size + ",");
            for (int i = 0; i < size; i++) {
                queue.offer(curr.children.get(i));
                sb.append(curr.children.get(i).val + ",");
            }
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] strs = data.split(",");
        Node root = new Node(Integer.valueOf(strs[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < strs.length) {
            int size = Integer.valueOf(strs[i++]);
            Node node = queue.poll();
            node.children = new ArrayList<>();
            int end = i + size; // i == 2, size == 4, end == 6
            while (i < end) {
                Node child = new Node(Integer.valueOf(strs[i++]));
                queue.offer(child);
                node.children.add(child);
            }
        }

        return root;
    }
}
