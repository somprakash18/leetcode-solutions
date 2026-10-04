class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int pile:piles){
            e=Math.max(e,pile);
        }
        int ans=e;
        while(s<=e){
            int k=s+(e-s)/2;
             long hours=0;
            for(int pile:piles){
               
                hours+=(pile+k-1)/k;
            }
                if(hours<=h){
                    ans=k;
                    e=k-1;
                }else {
                    s=k+1;
                }

            }
            return ans;
        }
    }
