/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    //TC : O(n)
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node child = head.child;
        Node next = head.next;
        
        //child와 next 모두 flat하게 만들기
        flatten(head.child);
        flatten(head.next);
        
        //head.right 위치에 child를 붙여주기
        Node cur = head;
        head.child = null;
        cur.next = child;
        if(child!=null) child.prev = head;
        
        //child의 맨 끝과 head.right를 이어주기
        while(cur.next!=null) cur = cur.next;
        cur.next = next;
        if(next!=null) next.prev = cur;
        
        return head;
    }
}
