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

    private Map<Integer, Integer> map = new HashMap<>();
    private int[] inorder, postorder;
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.inorder = inorder;
        this.postorder = postorder;
        this.index = postorder.length-1;

        for (int i = 0; i < inorder.length; i++) map.put(inorder[i],i);

        return build(0, postorder.length-1);

    }

    private TreeNode build(int L, int R) {

        TreeNode root = null;

        if (L > R) return null;
        if (index >= 0) {
            int rootVal = postorder[index--];
            root = new TreeNode(rootVal);
            int mid = map.get(rootVal);
            root.right = build(mid+1, R);
            root.left = build(L, mid-1);
        }

        return root;
    }
}