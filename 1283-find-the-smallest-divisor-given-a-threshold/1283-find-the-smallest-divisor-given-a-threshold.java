class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int s=1;
        int e=0;
        for(int num:nums){
          e=Math.max(e,num);
        }
        int ans=e;
        while(s<=e){
            int m=s+(e-s)/2;
            int sum=0;
            for(int num:nums){
                sum+=(num+m-1)/m;
            }
            if(sum<=threshold){
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