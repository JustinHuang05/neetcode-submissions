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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode result = new ListNode();
        ListNode temp = result;
        
        boolean hasLeftover = false;
        while (current1 != null || current2 != null) {
            int val1 = 0;
            int val2 = 0;

            if (current1 != null) {
                val1 = current1.val;
            } 

            if (current2 != null) {
                val2 = current2.val;
            } 

            int sum = val1 + val2;
            if (hasLeftover) {
                sum += 1;
            }

            int remainder = sum - 10;
            if (remainder >= 0) {
                temp.next = new ListNode(remainder);
                temp = temp.next;
                hasLeftover = true;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                hasLeftover = false;
            }

            if (current1 != null) {
                current1 = current1.next;
            }
            if (current2 != null) {
                current2 = current2.next;
            }
        }

        if (hasLeftover) {
            temp.next = new ListNode(1);
        }

        return result.next;
    }
}
