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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head == null || head.next==null){
            return true;
        }
       if(  head.next.next==null){
            return head.val==head.next.val;
        }

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
         if (fast != null) {
            slow = slow.next;
        }
        ListNode prev=null;
        
        ListNode cur=slow;
        
        while(cur!=null){
            ListNode nextnode=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextnode;
        
        }
       



        while(prev!=null){
            if(head.val==prev.val){
                head=head.next;
                prev=prev.next;
            }else{
                return false;
            }
            
        }
        return true;
        

    }
}