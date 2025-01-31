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
    private int len;
    public int diameterOfBinaryTree(TreeNode root) {
        len = 0;
        recurse(root);
        return len;
    }
    
    public int recurse(TreeNode node)
    {
        if(node == null)
            return 0;
        int leftPath = recurse(node.left);
        int rightPath = recurse(node.right);
        
        len = Math.max(len, leftPath + rightPath);
        
        return Math.max(leftPath, rightPath) + 1;
    }
}
