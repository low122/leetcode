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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        ListNode newHead = head.next;

        while (curr != null && curr.next != null) {
            ListNode first = curr;
            ListNode second = first.next;
            ListNode nextNode = second.next;

            first.next = nextNode;
            second.next = first;

            if (prev != null) {
                prev.next = second;
            }

            prev = first;
            curr = nextNode;
        }

        return newHead;
    }
}