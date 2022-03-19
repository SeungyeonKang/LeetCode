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
    public List<Double> averageOfLevels(TreeNode root) {
        /*
        int maximun depth;
        save every nodes with it's level in the list<double>
        
        while(queue is empty) 
            - get the queue size : It meand the number of nodes of the level
            - initialize sum = 0.0
            - for(i:n)
                - node = queue.poll()
                - sum += node.val
                - put it's child node to the queue (if it existed)
            - find average and put it to result list
            
        TC : O(n) //n : the number of all nodes. visit every node at once
        SC : O(n/2) = O(n) //Maximun number of leaves of a binary tree is n/2
        */
        
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root==null) return res;
        
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            Double sum = 0.0;
            for(int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(sum/n);
        }
        return res;
    }
}
