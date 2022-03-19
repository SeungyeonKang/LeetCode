/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        LCA : The lowest common ancestor 
        Node.val is Unique
        2<= number of nodes <= 100,000
        
        Find Node p and q in the tree.
        Find the LCA of the two nodes.
        
        TC : O(H) : height of the tree
        SC : O(1)
        */
        
        //Recursive
        //Because it's BST, p,q can be both smaller than root or both bigger than root
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
        
        //non-recursive
        // while (true) {
        //     if (root.val > p.val && root.val > q.val)
        //         root = root.left;
        //     else if (root.val < p.val && root.val < q.val)
        //         root = root.right;
        //     else
        //         return root;
        // }
    }
}
