package trie;

import java.util.ArrayList;
import java.util.List;

public class RouterLongestPrefix {
    class Node {
        boolean val;
        Node[] children;
        int port;
        Node(boolean val, int port) {
            this.children = new Node[2];
            this.val = val;
            this.port = port;
        }
    }

    private Node root;
    public RouterLongestPrefix() {
        this.root = new Node(false, 0);
    }

    private void build(List<Entry> entries) {
        for (Entry entry : entries) {
            Node curr = root;
            for (boolean val : entry.prefix) {
                int idx = val == false ? 0 : 1;
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node(val, 8);
                }
                curr = curr.children[idx];
            }
            curr.port = entry.port;
        }
    }

    public int route(boolean[] packet) {
        Node curr = root;
        for (boolean val : packet) {
            int idx = val == false ? 0 : 1;
            if (curr.children[idx] == null) {
                return curr.port;
            }
            curr = curr.children[idx];
        }
        return curr.port;
    }

    public static void main(String[] args) {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(new boolean[] {false,false,false}, 3));
        entries.add(new Entry(new boolean[] {true,false}, 4));
        entries.add(new Entry(new boolean[] {true}, 5));
        RouterLongestPrefix test = new RouterLongestPrefix();
        test.build(entries);
        System.out.println(test.route(new boolean[] {false,false,false,true,false}));
        System.out.println(test.route(new boolean[] {true,false,false,true}));
        System.out.println(test.route(new boolean[] {true,true,true}));
        System.out.println(test.route(new boolean[] {false,false,true,false,true,false}));
    }
}
