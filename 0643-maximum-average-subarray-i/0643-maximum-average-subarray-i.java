class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max=0,
        sum=0;
        for(int i=0;i<k;i=i+1){
            sum=sum+nums[i];
        }
        max=sum;
        for(int i=k;i<nums.length;i=i+1){
            sum=sum+nums[i];
            sum=sum-nums[i-k];
            max=Math.max(max,sum);
        }
        return max/k;
    }
}