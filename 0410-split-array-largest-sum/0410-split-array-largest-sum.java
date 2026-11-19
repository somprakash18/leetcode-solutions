class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0;
        int e=0;
        for(int num:nums){
            s=Math.max(s,num);
            e+=num;
        }
        int ans=e;
        while(s<=e){
            int m=s+(e-s)/2;
            int parts=1;
            int sum=0;
            for(int num:nums){
                if(sum+num>m){
                    parts++;
                    sum=num;;

                }
                else{
                    sum+=num;
                }
            }
            if(parts<=k){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
}