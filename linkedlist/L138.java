package linkedlist;

/* Copy list with random pointer */

public class L138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }

        Node res = head.next;
        Node pt = head.next;
        Node oldPt = head;
        while (oldPt != null) {
            oldPt.next = oldPt.next.next;
            pt.next = (pt.next == null) ? null : pt.next.next;
            oldPt = oldPt.next;
            pt = pt.next;
        }

        return res;
    }
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//
//        Map<Node, Node> map = new HashMap<>();
//        Node dummy = new Node(0);
//        Node curr = head;
//        Node copyCurr = dummy;
//        while (curr != null) {
//            if (!map.containsKey(curr)) {
//                Node currCopy = new Node(curr.val);
//                map.put(curr, currCopy);
//            }
//            copyCurr.next = map.get(curr);
//            if (curr.random != null) {
//                if (!map.containsKey(curr.random)) {
//                    Node randomCopy = new Node(curr.random.val);
//                    map.put(curr.random, randomCopy);
//                }
//                copyCurr.next.random = map.get(curr.random);
//            }
//            curr = curr.next;
//            copyCurr = copyCurr.next;
//        }
//
//        return dummy.next;
//    }
}
