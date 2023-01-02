# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#TC : O(n+m)
#SC : O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p1, p2 = headA, headB
        l1, last1 = self.getLast(p1)
        l2, last2 = self.getLast(p2)

        if last1 is not last2 : return None

        if l1 > l2 :
            headA = self.goForward(headA, l1-l2)
        elif l2 > l1 :
            headB = self.goForward(headB, l2-l1)

        while headA is not headB :
            headA = headA.next
            headB = headB.next
        return headA

    def getLast(self, p) :
        l = 1
        while p.next != None :
            l+=1
            p = p.next
        return l, p

    def goForward(self, p, step) :
        print(step)
        cnt = 0
        while cnt < step :
            cnt+=1
            p = p.next
        return p

        
