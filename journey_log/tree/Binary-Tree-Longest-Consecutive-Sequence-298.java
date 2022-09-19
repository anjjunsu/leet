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

    private int longest;

    public int longestConsecutive(TreeNode root) {
        
        if (root == null) return 0;

        longest = 1;

        recursionHelper(root.left, root.val, 1);
        recursionHelper(root.right, root.val, 1);

        return longest;
    }

    private void recursionHelper(TreeNode node, int parentVal, int count) {

        if (node == null) return;

        if (parentVal + 1 == node.val) {
            count++;
            longest = Math.max(longest, count);
        } else {
            count = 1;
        }

        recursionHelper(node.left, node.val, count);
        recursionHelper(node.right, node.val, count);

    }
}
