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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
        inorder traversal : left -> root -> right;
        TC : O(n)
        SC : O(1)
        */
        List<Integer> res = new ArrayList<>();
        addToList(root, res);
        return res;   
    }
    
    private void addToList(TreeNode root, List<Integer> list) {
        if(root==null) return;
        addToList(root.left, list);
        list.add(root.val);
        addToList(root.right, list);
    }
}
