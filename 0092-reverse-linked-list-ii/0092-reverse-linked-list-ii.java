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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int counter=0;
        ListNode p=dummy,
        c=head;
        while(counter<left-1){
            p=c;
            c=c.next;
            counter=counter+1;
        }
        ListNode prev=null,
        curr=c;
        counter=0;
        while(counter<(right-left+1)){
            counter=counter+1;
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        p.next=prev;
        c.next=curr;
        return dummy.next;
    }
}