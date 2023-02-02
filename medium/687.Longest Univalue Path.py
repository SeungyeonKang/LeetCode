# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC : O(n)
#SC : O(H)
class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        self.res = 0
        def helper(pVal, current)  :
            if current is None :
                return 0
            
            left = helper(current.val, current.left)
            right = helper(current.val, current.right)
            
            self.res = max(self.res, left+right)

            if pVal is not None and pVal == current.val :
                return max(left+1, right+1)
            else  :
                return 0
            
        helper(None, root)
        return self.res

