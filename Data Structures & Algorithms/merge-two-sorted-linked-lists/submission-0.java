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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode resultPointer = new ListNode();
        ListNode saveHead = resultPointer;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val <= pointer2.val) {
                System.out.println(pointer1.val + ": " + pointer2.val + " 1");
                resultPointer.next = pointer1;
                resultPointer = resultPointer.next;
                pointer1 = pointer1.next;
            } else {
                System.out.println(pointer1.val + ": " + pointer2.val + " 2");
                resultPointer.next = pointer2;
                resultPointer = resultPointer.next;
                pointer2 = pointer2.next;
            }
        }

        while (pointer1 == null && pointer2 != null) {
            resultPointer.next = pointer2;
            resultPointer = resultPointer.next;
            pointer2 = pointer2.next;
        }

        while (pointer1 != null && pointer2 == null) {
            resultPointer.next = pointer1;
            resultPointer = resultPointer.next;
            pointer1 = pointer1.next;
        }

        return saveHead.next;
    }
}