# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC : O(h) h: high of the BST
#SC : O(1)
class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        
        #node가 low보다 작으면 오른쪽 것만 취해서 트리를 만듦
        #node가 high보다 크면 왼쪽 것만 취함
        
        if root == None :
            return None
        
        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)
        
        if root.val < low : 
            return root.right
        elif root.val > high :
            return root.left
        else : 
            return root
        
        
        
        
        
        
        
        
