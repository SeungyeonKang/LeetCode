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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //해당 자리가 10을 넘는 경우 올림 할 1 저장해야함
        //l1, l2 하나씩 순회하면서 더함
        //l1==null l3.val = l2.val || l2==null l3.val = l1.val
        //Time Complexity : O(n)
        //Space Complexity : O(n)
        
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int plus = 0;
        
        while(l1!=null || l2!=null) {
            int sum = 0; 
            if(l1==null) {
                sum += l2.val;
                l2=l2.next;
            } 
            if(l2==null) {
                sum = l1.val;
                l1=l1.next;
            } 
            
            sum +=plus;
            l3.next = new ListNode(sum%10);
            plus = sum/10 == 1 ? 1 : 0;
            l3=l3.next;
        }
        
        if(plus==1) l3.next = new ListNode(1);
        return head.next;
    }
}
