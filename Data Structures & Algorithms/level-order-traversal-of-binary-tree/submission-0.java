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
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>(Collections.singleton(root));
        while (!nodes.isEmpty()) {
            int sz = nodes.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode top = nodes.poll();

                level.add(top.val);
                if (top.left != null)
                    nodes.offer(top.left);
                if (top.right != null)
                    nodes.offer(top.right);
            }

            levels.add(level);
        }

        return levels;
    }
}
