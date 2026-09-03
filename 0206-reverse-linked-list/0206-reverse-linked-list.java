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
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int len=0;
        ListNode l=head;
        while(l!=null){

            l=l.next;
            len=len+1;
        }
        ListNode[]arr=new ListNode[len];
         l=head;
         int i=0;
        while(l!=null){
            arr[i]=l;
            i=i+1;
            l=l.next;
        }
        int start=0,
        end=len-1;
        while(start<end){
            ListNode temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start=start+1;
            end=end-1;
        }
        for(int k=0;k<len-1;k=k+1){
            arr[k].next=arr[k+1];
        }
        arr[len-1].next=null;
        return arr[0];
    }
}