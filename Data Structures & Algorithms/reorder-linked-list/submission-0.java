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
    public void reorderList(ListNode head) {
        ListNode countPointer = head;
        int count = 0;
        while (countPointer != null) {
            count++;
            countPointer = countPointer.next;
        }

        int breakPoint = count / 2 + 1;

        ListNode breakHead = head;
        int countToBreak = 1;
        while (breakHead != null && countToBreak < breakPoint) {
            breakHead = breakHead.next;
            countToBreak++;
        }

        ListNode current = breakHead;
        ListNode previous = null;
        while (current != null) {
            ListNode saveNext = current.next;
            current.next = previous;
            previous = current;
            current = saveNext;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = previous;
        ListNode resultPointer = new ListNode();
        ListNode result = resultPointer;

        int evenOdd = 1;
        while (pointer1 != null && pointer2 != null) {
            if (evenOdd % 2 != 0) {
                resultPointer.next = pointer1;
                resultPointer = resultPointer.next;
                pointer1 = pointer1.next;
            } else {
                resultPointer.next = pointer2;
                resultPointer = resultPointer.next;
                pointer2 = pointer2.next;
            }
            evenOdd++;
        }

        head = result.next;
    }
}
