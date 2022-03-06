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
    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        inOrderTraverse(root, values);

       for(int i = 0; i < values.size() - 1; i++) {
           if (values.get(i) >= values.get(i + 1)) {
               return false;
           }
       } 

       return true;
    }

    private void inOrderTraverse(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left, vals);
        vals.add(node.val);
        inOrderTraverse(node.right, vals);
    }
}