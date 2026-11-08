class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int[]pos=new int[n/2];
        int[]neg=new int[n/2];
        int p=0;
        int     q=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                pos[p]=nums[i];
                p++;
            }
            else{
                neg[q]=nums[i];
                q++;
            }
        }
            int[]ans=new int[n];
            for(int i=0;i<n/2;i++){
                ans[2*i]=pos[i];
                ans[2*i+1]=neg[i];

            }
            return ans;
        
    }
}