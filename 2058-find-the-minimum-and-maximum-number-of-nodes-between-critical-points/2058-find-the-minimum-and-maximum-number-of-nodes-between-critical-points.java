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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head,
        curr=head.next;
        int position=1,
        prevCriticalPos=-1,firstCriticalPos=-1,minDist=Integer.MAX_VALUE;
        while(curr.next!=null){
            if((curr.val<prev.val && curr.val<curr.next.val) ||(curr.val>prev.val && curr.val>curr.next.val)){
                if(firstCriticalPos==-1){
                    firstCriticalPos=position;
                }else{
                    minDist=Math.min(minDist,position-prevCriticalPos);}
                    prevCriticalPos=position;
                   
                
            }
            position++;
            prev=curr;
            curr=curr.next;
        }
        if(minDist==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        int maxDist=prevCriticalPos-firstCriticalPos;
        return new int[]{minDist,maxDist};
        
    }
}