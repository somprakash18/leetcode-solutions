class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=0;
        int e=0;
        for(int weight:weights){
            s=Math.max(s,weight);
            e+=weight;
            
        }
        int ans=e;
            while(s<=e){
                int m=s+(e-s)/2;
                int rd=1;
                int cd=0;
                for(int weight:weights){
                    if(cd+weight<=m){
                        cd+=weight;
                    }else{
                        rd++;
                        cd=weight;
                    }
                }
                if(rd<=days){
                    ans=m;
                    e=m-1;
                }else{
                    s=m+1;
                }
            }
            return ans;
        }
    }
