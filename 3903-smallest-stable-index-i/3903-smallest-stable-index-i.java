class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[]minFromIndex=new int[n];
        int minE1=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            minE1=Math.min(minE1,nums[i]);
            minFromIndex[i]=minE1;
        }
        int maxE1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxE1=Math.max(maxE1,nums[i]);
            if(maxE1-minFromIndex[i]<=k){
                return i;
            }
        }
        return -1;
    }
}