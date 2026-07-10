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
        // if (root == null) {
        //     return 0;
        // }

        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        if (root == null) {
            return 0;
        }

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();

        int maxDepth = 0;

        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();

            if (cur.getKey() != null) {
                maxDepth = Math.max(cur.getValue(), maxDepth);
                stack.push(new Pair(cur.getKey().left, cur.getValue() + 1));
                stack.push(new Pair(cur.getKey().right, cur.getValue() + 1));
            }
        }

        return maxDepth;
    }
}
