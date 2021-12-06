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

//diameter-of-binary-tree
class Solution {
    //트리의 끝에서 끝까지가는 가장 긴 경로. root를 거칠 수도 있고, 거치지 않을 수도 있음
    //int maxDepth = 0;
    //depth = findDepth(root.left) + findDepth(root.right))
    //maxDepth = Math.max(depth, maxDepth);
    //Time Complexity : O(n)
    //Space Complexity : O(n)
    int maxDepth = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        findDepth(root);
        return maxDepth;
    }
    
    public int findDepth(TreeNode root) {
        if(root==null) return 0;
        
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        maxDepth = Math.max(left + right, maxDepth);
        return Math.max(left,right) + 1;
        
    }
}
