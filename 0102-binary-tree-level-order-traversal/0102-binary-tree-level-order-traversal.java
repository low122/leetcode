/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
         List<List<Integer>> outerList = new ArrayList<>();

         if (root == null) {
            return new ArrayList<>();
         }

         queue.offer(root);

         while (!queue.isEmpty()) {

            List<Integer> innerList = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                System.out.println("Size: " + queue.size());
                TreeNode currNode = queue.poll();

                innerList.add(currNode.val);
                System.out.println(currNode.val);

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);

            }

            System.out.println("----");
            outerList.add(innerList);

            
        }

        return outerList;
    }
}