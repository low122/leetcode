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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> outerList = new ArrayList<>();
        int count = 1;

        if (root == null) return new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> innerList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (count % 2 != 0) {
                    innerList.add(currNode.val); // left to right
                } else {
                    innerList.add(0, currNode.val); // right to left
                }
                
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }

            count++;
            outerList.add(innerList);
        }

        return outerList;
    } 
}