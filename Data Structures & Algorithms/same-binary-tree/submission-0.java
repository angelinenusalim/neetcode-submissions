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
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode current_p = q1.poll();
            TreeNode current_q = q2.poll();
            if (current_p == null && current_q == null) continue;
            if (current_p == null && current_q != null) return false;
            if (current_p != null && current_q == null) return false;
            q1.offer(current_p.left);
            q2.offer(current_q.left);
            q1.offer(current_p.right);
            q2.offer(current_q.right);
            if (current_p.val != current_q.val) {
                return false;
            }
        }
        return true;
    }
}
