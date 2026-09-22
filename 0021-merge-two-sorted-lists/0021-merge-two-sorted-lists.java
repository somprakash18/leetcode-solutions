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
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(p1!=null && p2!=null){
            if (p1.val<=p2.val){
                temp.next=p1;
                temp=temp.next;
                p1=p1.next;
            }else if(p1.val>p2.val){
                temp.next=p2;
                temp=temp.next;
                p2=p2.next;
            }
             if(p1!=null){
                temp.next=p1;
            }else if(p2!=null) {
                temp.next=p2;
            }
        }
        return dummy.next;
    }
}