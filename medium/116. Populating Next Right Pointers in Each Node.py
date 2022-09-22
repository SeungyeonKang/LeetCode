"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

import queue

#TC : O(n)
#SC : O(1)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None : 
            return root
        
        q = queue.Queue()
        q.put(root)
        
        while q.qsize() != 0 :
            
            size = q.qsize()
            for i in range(size) :
                node = q.get()
                
                if i != size-1 :
                    node.next = q.queue[0]   #q.peek()
                
                if node.left != None :
                    q.put(node.left)
                if node.right != None :
                    q.put(node.right)
                    
        return root
        
        
        
