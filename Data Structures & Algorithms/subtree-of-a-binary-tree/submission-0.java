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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        boolean leftBool = isSubtree(root.left, subRoot);
        boolean rightBool = isSubtree(root.right, subRoot);

        return leftBool || rightBool;
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null && b != null || a != null && b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        boolean aBool = isSameTree(a.left, b.left);
        boolean bBool = isSameTree(a.right, b.right);

        return aBool && bBool;
    }
}
