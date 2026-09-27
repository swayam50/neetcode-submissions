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
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null)
            return 0;
        
        int leftDepth = maxDepth(node.left, depth + 1);
        int rightDepth = maxDepth(node.right, depth + 1);

        return Math.max(depth, Math.max(leftDepth, rightDepth));
    }
}
