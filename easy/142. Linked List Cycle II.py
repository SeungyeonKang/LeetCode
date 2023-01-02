# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

'''
When slow pointer is reach the loop start point, fast pointer is as fast as K than slow.
It means that fast Pointer and slow Pointer will meet at the point which is far K from Loop Start Point.
Head is also far K from Loop Strat Point
Therefore, the point where head and fast/slow meet when they move with same speed is the loop start point. 

TC : O(n)
SC : O(1)
'''

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast, slow = head, head

        while fast != None and fast.next != None:
            fast = fast.next.next
            slow = slow.next
            if slow is fast : break
        
        if fast == None or fast.next == None : return None

        slow = head
        while slow != fast :
            slow = slow.next
            fast = fast.next
        return fast

