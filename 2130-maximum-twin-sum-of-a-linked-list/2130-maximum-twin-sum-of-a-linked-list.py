# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:


        
        slow = head
        fast = head
        prev = head
        maxNum = 0
        stack = []

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        secondHalf = slow
        while secondHalf:
            stack.append(secondHalf.val)
            secondHalf = secondHalf.next

        while prev != slow and stack:
            temp = prev.val + stack.pop()
            maxNum = max(maxNum, temp)
            prev = prev.next

        return maxNum
