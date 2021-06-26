package linkedlist;

/* Copy list with random pointer */

public class L138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        // Duplicate the current nodes
        while (curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        // Chain up the random of the copied nodes
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }

        // Break the chain and have the duplicated list
        Node res = head.next;
        Node pt = head.next;
        Node oldPt = head;
        while (oldPt != null) {
            // oldPt would have a copied one so oldPt.next will not be null
            oldPt.next = oldPt.next.next;
            // pt.next doesn't have a copied one so pt.next will likely be null
            pt.next = (pt.next == null) ? null : pt.next.next;
            oldPt = oldPt.next;
            pt = pt.next;
        }

        return res;
    }
    /*
         a  ->  b  ->  c  ->  d  ->  e
dummy -> a' ->  b ....
         copyCurr.next = map.get(a)
         copyCurr.next.random = map.get(a.random)

     */
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
              // copyCurr is one ahead of the copied node
              // One offset here, but why do we need this?
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
