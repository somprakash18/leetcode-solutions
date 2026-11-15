class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int pile:piles){
            e=Math.max(e,pile);
        }
        int ans=e;
         while(s<=e){
            int m=s+(e-s)/2;
            long hours=0;
            for(int pile:piles){
               hours+=(pile+m-1)/m;
            }
               if(hours<=h){
                ans=m;
                e=m-1;
               }else{
                s=m+1;
               }
            }
         
         return ans;
    }
}