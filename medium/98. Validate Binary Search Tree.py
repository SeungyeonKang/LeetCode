# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        '''
        - check left node  :
        if the maximun valus is lower than root.val & left tree is valid => left is true
        - check right node :
        if the minimun valus is bigger than root.val & right tree is valid => right is true
        - if left and right is valid => current tree is valid!
        => Recursive
        TC : O(n)
        SC : O(n)
        '''
        def helper(max_node, min_node, root) :
            if root == None : return True
            if root.val >= max_node or root.val <= min_node : return False
            
            if helper(max_node, root.val, root.right) and helper(root.val, min_node, root.left) :
                return True
        
        right = helper(math.inf, root.val, root.right)
        left = helper(root.val , -math.inf, root.left)
        
        return right and left
        
    
        
        
