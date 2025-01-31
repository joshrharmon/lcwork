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
        ArrayList<Integer> rightSide = new ArrayList<>();
		if(root != null) {
			Deque<TreeNode> temp = new ArrayDeque<>();
			temp.offer(root);
			while(!temp.isEmpty()) {
				ArrayList<Integer> tempLvl = new ArrayList<>();
				int tempLen = temp.size();
				for(int i = 0; i < tempLen; i++) {
					TreeNode tmpNode = temp.poll();
					if(tmpNode.left != null) {
						temp.offer(tmpNode.left);
					}
					if(tmpNode.right != null) {
						temp.offer(tmpNode.right);
					}
					tempLvl.add(tmpNode.val);
				}
				rightSide.add(tempLvl.get(tempLen - 1));
			}
		}
		return rightSide;
    }
}