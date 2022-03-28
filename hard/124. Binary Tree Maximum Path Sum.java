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
    int max = -1001;
    //TC : O(n)
    //SC : O(n)
    public int maxPathSum(TreeNode root) {
        /*
        maxPathSum(root.left)+root < root = don't have to care root.left
        maxPathSum(root.right)+root < root = don't have to care root.right
        */
        
        findMaxSun(root);
        return max;
    }
    
    private int findMaxSun(TreeNode root) {
        if(root == null) return 0;
        
        int currentSum = root.val, left, right;
        left = Math.max(findMaxSun(root.left), 0);
        right = Math.max(findMaxSun(root.right),0);
        max = Math.max(root.val+left+right, max);
        
        return Math.max(root.val+left, root.val+right);
    }
}
