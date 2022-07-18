/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //TC : O(n)
    //SC : O(1)
    public ListNode detectCycle(ListNode head) {
        while(head!=null) {
            if(head.val > 100000) {
                return head;
            }
            
            head.val = 100001;
            head = head.next;
        }
        return null;
    }
}

