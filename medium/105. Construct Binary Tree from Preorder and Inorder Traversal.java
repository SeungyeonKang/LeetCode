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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        Divide and Conquer
        - Root : 1st index's value in preorder array
        - find the index from inorder[] array
        - left side of the index in inorder[] => left children of root!
        - right side of the index in inorder[] => right children of root!
        - preorer[root index+1] : root's left child
        - preorer[root index + number of left children] : root's right child
        - number of left children : number of leftside index in inorder[]
        */
        
        return makeTree(0, 0, inorder.length-1, preorder, inorder);
    }
    
    TreeNode makeTree(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preIndex >= preorder.length || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preIndex]);
        
        int inorderIdx=0;
        for(int i=0;i<inorder.length; i++){
            if(inorder[i] == node.val) {
                inorderIdx = i;
            }
        }
        
        node.left = makeTree(preIndex + 1, inStart, inorderIdx-1, preorder, inorder);
        node.right = makeTree(preIndex + 1 + inorderIdx - inStart, inorderIdx+1, inEnd, preorder, inorder);
        return node;
    }
    
}
