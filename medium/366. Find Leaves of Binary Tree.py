# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        '''
        while()
            if : it's both child is null
                put it to the array and remove it.
            else :
                left != null, left의 leaf를 찾음
                right !=null, right의 leaf를 찾음
        '''
        
        self.result = []
        
        while root.left != None or root.right!=None :
            self.tmp = []
            
            if root.right != None :
                root.right = self.findLeaf(root.right)
                
            if root.left != None :
                root.left = self.findLeaf(root.left)
                
            self.result.append(self.tmp)
               
        self.result.append([root.val])
        
        return self.result
    
    def findLeaf(self, root) :
        if root.left == None and root.right == None :
            self.tmp.append(root.val)
            root = None
            
        else :
            if root.right != None :
                root.right = self.findLeaf(root.right)
                
            if root.left != None :
                root.left = self.findLeaf(root.left)
        return root
        
