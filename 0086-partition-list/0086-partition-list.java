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
    public ListNode partition(ListNode head, int x) {
        
        if (head == null) return head;

        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        beforeHead.next = null;
        afterHead.next = null;
        ListNode curr = head;

        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (curr != null) {
            if (curr.val < x) {
                before.next = curr;
                before = before.next;
            } else {
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }

        // Set the last node point to null
        after.next = null;

        before.next = afterHead.next;

        return beforeHead.next;
    }
}