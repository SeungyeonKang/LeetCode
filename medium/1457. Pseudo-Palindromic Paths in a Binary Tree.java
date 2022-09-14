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
    //TC : O(n)
    int resultCount;
    public int pseudoPalindromicPaths (TreeNode root) {
        /*
        1. iterate root from each leaf node
        2. make a list of the prev val
        3. check if it's palandrom or not
        => DFS 이용
        */
        int[] count = new int[10];
        dfs(root, count);
        return resultCount;
    }
    
    public void dfs(TreeNode root, int[] count) {
        
        if(root == null) return;
        
        count[root.val]++;
        if(root.left == null && root.right == null) {
            if(isPalandrome(count))  resultCount++;
        } else {
            dfs(root.left, count);
            dfs(root.right, count);
        }
        count[root.val]--;
    }
    
    public boolean isPalandrome(int[] count) {
        int odd=0;
        for(int i=0;i < count.length;i++){
            if(count[i] % 2 != 0) {
              odd++;  
            } if(odd>1) return false;
        }
        return true;
    }
}
