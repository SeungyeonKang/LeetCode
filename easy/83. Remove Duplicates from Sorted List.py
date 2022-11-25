# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    #TC : O(n) 
    #SC : O(1)
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur, curVal, prev = head, None, head
        while cur!=None :
            if curVal == cur.val :
                prev.next = cur.next
            else : 
                prev = cur
                curVal = cur.val
            cur = cur.next
        return head
