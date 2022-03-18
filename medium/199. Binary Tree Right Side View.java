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
        List<Integer> result = new ArrayList<>();        
        rightView(root, 0, result);
        return result;
        
    }
    
    private void rightView(TreeNode root, int level, List<Integer> result) {
        //PreOrder Traversal
	if(root == null) return;
        
	//If it's the most right side  node for the level
	if(level==result.size()) result.add(root.val);
        rightView(root.right, level+1, result);
        rightView(root.left, level+1, result);
    }
}
