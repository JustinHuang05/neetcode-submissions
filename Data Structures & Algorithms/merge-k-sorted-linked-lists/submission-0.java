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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode pointer = result;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (ListNode list : lists) {
            minHeap.add(list);
        }

        while (!minHeap.isEmpty()) {
            ListNode currentMin = minHeap.poll();
            pointer.next = currentMin;
            pointer = pointer.next;
            if (pointer.next != null) {
                minHeap.add(pointer.next);
            }
        }

        return result.next;
    }
}
