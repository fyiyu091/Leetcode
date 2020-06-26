package bst;

/* Queue reconstruction by height */

import java.util.Arrays;

public class L406 {
    class Node {
        private Node left, right;
        private int start, end;
        private int leftSize;
        Node(int start, int end, int leftSize) {
            this.start = start;
            this.end = end;
            this.leftSize = leftSize;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }

        int len = people.length;
        int[][] res = new int[len][2];
        Arrays.sort(people, (int[] a, int[] b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        Node root = buildTree(0, len - 1);

        // now need to based on the element in the people array and find its index
        for (int[] num : people) {
            int rank = num[1] + 1;
            int idx = findIdx(root, rank);
            res[idx][0] = num[0];
            res[idx][1] = num[1];
        }

        return res;
    }

    private int findIdx(Node root, int rank) {
        Node curr = root;
        while (curr != null && curr.start < curr.end) { //all the way until the leaf node
            if (rank <= curr.leftSize) {
                curr.leftSize--;
                curr = curr.left;
            }
            else {
                rank -= curr.leftSize;
                curr = curr.right;
            }
        }
        curr.leftSize = 0;
        return curr.start;
    }

    private Node buildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(start, end, 1);
        }

        int mid = start + (end - start) / 2;
        Node root = new Node(start, end, mid - start + 1);
        root.left = buildTree(start, mid);
        root.right = buildTree(mid + 1, end);
        return root;
    }
}
