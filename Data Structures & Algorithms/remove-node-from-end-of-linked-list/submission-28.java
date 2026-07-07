/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode first = dummyNode;
        ListNode second = head;

        for (int i = 1; i <= n; i++) {
            if (second == null && i < n) {
                return null;
            } else if (i < n) {
                second = second.next;
            }
        }
        
        ListNode previous = new ListNode();
        while (second.next != null) {
            previous = first;
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return dummyNode.next;
    }
}
