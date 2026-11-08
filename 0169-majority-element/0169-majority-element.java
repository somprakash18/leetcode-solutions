class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                c=nums[i];
                
            }
            if(nums[i]==c){
                count++;
            }else{
                count--;
            }

        }
        return c;
    }
}