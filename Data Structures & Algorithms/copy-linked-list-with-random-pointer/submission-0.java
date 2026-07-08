/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        Node iterator = head;
        while (iterator != null) {
            map.get(iterator).next = map.get(iterator.next);
            map.get(iterator).random = map.get(iterator.random);
            iterator = iterator.next;
        }

        return map.get(head);
    }
}
