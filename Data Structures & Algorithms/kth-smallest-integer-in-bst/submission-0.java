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
    private class IntegerWrapper {
        int count;
        Integer num;

        IntegerWrapper(int count) {
            this.count = count;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        IntegerWrapper box = new IntegerWrapper(k);
        kthSmallest(root, box);
        return box.num;
    }

    private void kthSmallest(TreeNode root, IntegerWrapper box) {
        if (root.left != null)
            kthSmallest(root.left, box);

        if (box.count == 0)
            return;
        
        box.count--;
        box.num = root.val;

        if (root.right != null)
            kthSmallest(root.right, box);
    }
}
