package linkedlist;

/* Copy list with random pointer */

import java.util.HashMap;
import java.util.Map;

public class L138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node curr = head;
        Node copyCurr = dummy;
        while (curr != null) {
            if (!map.containsKey(curr)) {
                Node currCopy = new Node(curr.val);
                map.put(curr, currCopy);
            }
            copyCurr.next = map.get(curr);
            if (curr.random != null) {
                if (!map.containsKey(curr.random)) {
                    Node randomCopy = new Node(curr.random.val);
                    map.put(curr.random, randomCopy);
                }
                copyCurr.next.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }
}
