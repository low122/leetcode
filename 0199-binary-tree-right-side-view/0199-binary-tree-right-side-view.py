# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        answer = []
        queue = deque()

        if not root:
            return answer

        queue.append(root)

        while queue:

            length = len(queue)

            for _ in range(length):

                currNode = queue.popleft()

                if currNode.left:
                    queue.append(currNode.left)

                if currNode.right:
                    queue.append(currNode.right)

                last = currNode

            answer.append(last.val)

        return answer