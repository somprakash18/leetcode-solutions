class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1;
        int last=-1;
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target==nums[m]){
                first=m;
                e=m-1;
            
        }else if(target<nums[m]){
            e=m-1;
        }else if(target>nums[m]){
            s=m+1;
        }
       
    }
        s=0;
         e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target==nums[m]){
                last=m;
                s=m+1;
            
        }else if(target<nums[m]){
            e=m-1;
        }else if(target>nums[m]){
            s=m+1;
        }
}
return new int[]{first,last};
    }
}