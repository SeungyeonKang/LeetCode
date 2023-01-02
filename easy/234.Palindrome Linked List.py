# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

TC : O(n)
SC : O(n)

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        stack =  []
        p1 = p2 = head

        while p1 != None:
            if p1.next == None :
                p2 = p2.next
                break
                
            stack.append(p2.val)
            p1 = p1.next.next
            p2 = p2.next

        if len(stack) == 0 : return True

        while p2 != None :
            if p2.val != stack.pop() : return False
            p2 = p2.next
        return True
            
