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
    public boolean isValidBST(TreeNode root) {
        /*
        leftNode.val < root.value
        rightNode.val > root.value
        
        1<=Number of Nodes <=10^4
        each Node's value => Integer range
        
        TC : O(n)
        SC : O(n)
        */
        
        return isValidTree(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean isValidTree(TreeNode node, long max, long min){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        
        return isValidTree(node.left, node.val, min) && isValidTree(node.right, max, node.val);
    }
}
