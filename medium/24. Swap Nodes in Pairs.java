/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //TC : O(n)
    //SC : O(1)
    public ListNode swapPairs(ListNode head) {
        
        if(head == null) return head;
        
        ListNode start = new ListNode();
        start.next = head;
        ListNode result = start;

        while(start.next !=null && start.next.next !=null) {
            ListNode a = start.next;
            ListNode b = start.next.next;
            a.next = b.next;
            b.next = a;
            start.next = b;
            start = start.next.next;  
        }
        return result.next;
    }
}
