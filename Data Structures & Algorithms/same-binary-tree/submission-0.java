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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pVals = constructTreeList(p);
        List<Integer> qVals = constructTreeList(q);

        return pVals.equals(qVals);
    }

    private List<Integer> constructTreeList(TreeNode node) {
        Queue<TreeNode> nodes = new LinkedList<>(Collections.singleton(node));
        
        List<Integer> vals = new LinkedList<>();
        while (!nodes.isEmpty()) {
            TreeNode top = nodes.poll();
            if (Objects.isNull(top))
                vals.add(null);
            else {
                vals.add(top.val);
                nodes.offer(top.left);
                nodes.offer(top.right);
            }
        }

        return vals;
    }
}
