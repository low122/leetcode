# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        if not head or not head.next:
            return head
        
        prev = head
        curr = head.next
        currHead = curr

        while curr and curr.next:
            prev.next = curr.next
            prev = prev.next

            curr.next = prev.next
            curr = curr.next

        prev.next = currHead

        return head