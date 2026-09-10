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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode prev=null,curr=slow;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode l1=head,l2=prev;
        while(l2.next!=null){
            ListNode l1N=l1.next;
            l1.next=l2;
            ListNode l2N=l2.next;
            l2.next=l1N;
            l1=l1N;
            l2=l2N;
        }
    }
}