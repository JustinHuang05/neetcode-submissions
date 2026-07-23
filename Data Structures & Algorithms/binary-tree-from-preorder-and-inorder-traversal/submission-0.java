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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
            }
        }
        
        int[] leftPreArray = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] leftInArray = Arrays.copyOfRange(inorder, 0, rootIndex);
        root.left = buildTree(leftPreArray, leftInArray);

        int[] rightPreArray = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] rightInArray = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        root.right = buildTree(rightPreArray, rightInArray);

        return root;
    }
}
