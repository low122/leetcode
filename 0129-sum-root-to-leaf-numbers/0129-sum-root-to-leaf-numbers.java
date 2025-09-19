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
    public int sumNumbers(TreeNode root) {
        return buildValue(root, 0);
    }

    private int buildValue(TreeNode root, int value) {

        if (root == null) return 0;

        value = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            return value;
        }

        return buildValue(root.left, value) + buildValue(root.right, value);
    }
}