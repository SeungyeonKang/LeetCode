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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode start = new ListNode();
        ListNode fast = start, slow = start;
        start.next = head;
        
        if(head==null || head.next == null) return head;
        
        int size;
        for(size=0; fast.next!=null; size++) {
            fast = fast.next;
        }
        
        for(int i=0;i<size - k%size; i++){
            slow = slow.next;
        }
        
        fast.next = start.next;
        start.next = slow.next;
        slow.next = null;
        
        return start.next;
    }
}
