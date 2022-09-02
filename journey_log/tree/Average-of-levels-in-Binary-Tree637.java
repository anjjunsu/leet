import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Queue<TreeNode> tempQ = new LinkedList<>();
            Double sum = Double.valueOf(0);
            Long count = Long.valueOf(0);

            while (!q.isEmpty()) {
                TreeNode node = q.poll();

                sum += node.val;
                count++;

                if (node.left != null)
                    tempQ.add(node.left);

                if (node.right != null)
                    tempQ.add(node.right);
            }

            result.add(Double.valueOf(sum / count));
            q = tempQ;
        }

        return result;
    }
}