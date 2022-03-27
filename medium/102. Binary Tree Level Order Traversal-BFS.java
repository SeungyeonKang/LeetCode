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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        [0,2000]
        [-1000, 1000]
        
        Data Structure : Queue
        
        TC : O(n)
        SC : O(n/2) => O(n)
        */
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        queue.add(root);
        
        while(queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(); //for each level nodes
            
            for(int i = 0; i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            result.add(list);
        }
        
        return result;
        
    }
}
