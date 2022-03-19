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
    public List<String> binaryTreePaths(TreeNode root) {
        /*
        Get the root-to-leaf path of left child
        Get the root-to-right path of right child
        "any order" -> I will use pre-order traversal
        
        Use StringBuilder instead of String (for saving memory)
        Since StringBuilder is pass by reference, 
        need to rollback stringbuilder at the last line of each method.
        
        TC : O(n)
        SC : O(H) : H is tree height
        */
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        rootToLeaf(root, sb, res);
        return res;
    }
    
    private void rootToLeaf(TreeNode node, StringBuilder sb, List<String> res) {
        if(node==null) {
            return;
        }
        int len = sb.length();
        sb.append(node.val);
        if(node.right == null&& node.left == null) res.add(sb.toString());
        else {
            sb.append("->");
            rootToLeaf(node.left, sb, res);
            rootToLeaf(node.right, sb, res);
        }
        sb.setLength(len);
    }
}
