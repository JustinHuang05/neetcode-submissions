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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] goodNodes = new int[1];
        goodNodes[0] = 0;

        dfs(root, goodNodes, root.val);

        return goodNodes[0];
    }

    private void dfs(TreeNode root, int[] goodNodes, int curMaxVal) {
        if (root == null) {
            return;
        }

        int curMax = curMaxVal;
        if (root.val >= curMax) {
            goodNodes[0] += 1;
            curMax = root.val;
        } 

        dfs(root.left, goodNodes, curMax);
        dfs(root.right, goodNodes, curMax);
    }
}
