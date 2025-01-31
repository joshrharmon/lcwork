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
	private int numGoodNodes = 0;
	
    public int goodNodes(TreeNode root) {
        isGood(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
	
	public void isGood(TreeNode node, int maxSoFar) {
		if(node.val >= maxSoFar) {
			numGoodNodes++;
		}
		
		if(node.left != null) {
			isGood(node.left, Math.max(node.val, maxSoFar));
		}
		
		if(node.right != null) {
			isGood(node.right, Math.max(node.val, maxSoFar));
		}
	}
}