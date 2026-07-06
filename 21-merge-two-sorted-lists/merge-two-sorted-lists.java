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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode result=new ListNode(-1);
        ListNode head=result;
        
        while(p1!=null &&p2!=null ){
            if(p1.val<=p2.val){
                head.next=new ListNode(p1.val);
                head=head.next;
                p1=p1.next;

            }else {
                head.next=new ListNode(p2.val);
                head=head.next;
                p2=p2.next;
            }
        }
        if(p1!=null){
            head.next=p1;
        }else if(p2!=null){
            head.next=p2;
        }
        return result.next;
    }
}