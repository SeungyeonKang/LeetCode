# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#TC : O(N), SC : O(NM) => N : len(l1), M :len(l2)
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

        node = ListNode(0)
        head = node

        carry = 0
        while l1 != None or l2 != None or carry > 0 :
            c_sum = 0
            if l1 != None :
                c_sum += l1.val
                l1 = l1.next
            if l2 != None :
                c_sum += l2.val
                l2 = l2.next
            c_sum += carry
            if c_sum > 9 :
                carry = 1
                c_sum%=10
            else :
                carry = 0

            node.next = ListNode(c_sum)
            node = node.next
        return head.next





