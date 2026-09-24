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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(true){
        ListNode kth=prev;
        for(int i=0;i<k;i++){
            if(kth==null){
                break;
            }
            kth=kth.next;
        }
            if(kth==null){
                break;
            }
        ListNode groupNext=kth.next;
        ListNode prevNode=groupNext;
        ListNode curr=prev.next;
       
        while(curr!=groupNext){
            ListNode next=curr.next;
            curr.next=prevNode;
            prevNode=curr;
            curr=next;
        }
        ListNode oldfirst=prev.next;
        prev.next=prevNode;
        prev=oldfirst;
        }
        return dummy.next;
    }
}
    