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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nodeA=head;
        while(nodeA!=null){
            ListNode nodeB=nodeA.next;
            int val=nodeA.val;
            while(nodeB!=null&&val==nodeB.val){
                nodeB=nodeB.next;
            }
            nodeA.next=nodeB;
            nodeA=nodeB;
        }
        return head;
    }
}