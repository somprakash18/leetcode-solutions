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
    public int getDecimalValue(ListNode head) {
        if(head==null){
            return 0;
        }
        ListNode p=head;
       int ans=0;
    while(p!=null){
        ans=2*ans+p.val;
        p=p.next;
    }
    return ans;
    }
}