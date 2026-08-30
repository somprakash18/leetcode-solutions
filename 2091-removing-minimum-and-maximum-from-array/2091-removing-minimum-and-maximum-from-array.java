class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minIdx=0,maxIdx=0;
        
        for(int i =0;i<n;i++){
            if(nums[i]<nums[minIdx]){
                minIdx=i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx=i;
            }
        }
        if(minIdx>maxIdx){
            int temp=minIdx;
            minIdx=maxIdx;
            maxIdx=temp;
        }
        int option1=maxIdx +1;
        int option2=n-minIdx;
        int option3=(minIdx+1)+(n-maxIdx);
        return Math.min(option1,Math.min(option2,option3));


    }
}