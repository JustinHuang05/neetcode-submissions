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
    public List<Integer> rightSideView(TreeNode root) {
        //use BFS, for each level, just add the highest value to the result list

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            int max = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = q.pop();
                max = Math.max(max, curNode.val);
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
            result.add(max);
        }

        return result;
    }
}
