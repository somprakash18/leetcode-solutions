class Solution {
    public int minSubArrayLen(int target, int[] nums) {
int size=Integer.MAX_VALUE;
int sum=0;
int i=0,j=0;
while(j<nums.length){
    sum=sum+nums[j];
    while(sum>=target){
        size=Math.min(size,j-i+1);
        sum=sum-nums[i];
        i=i+1;
    }
    j=j+1;
}
return size==Integer.MAX_VALUE?0:size;
    }
}