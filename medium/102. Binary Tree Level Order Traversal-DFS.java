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
        
        TC : O(n)
        SC : O(n/2) => O(n)
        */
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if(root==null) return;
        
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        
        dfs(res, root.left, level+1);
        dfs(res, root.right, level+1);
    }
}
