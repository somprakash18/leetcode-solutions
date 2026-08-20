class Solution {
    public int[] sortArray(int[] nums) {
       mergeSort(nums,0,nums.length-1);
       return nums;

        
    }
    public void mergeSort(int[]nums,int start,int end ){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,start,mid,end);

    }
    public void merge(int[]nums,int start,int mid,int end){
        int[]temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid&& j<=end){
            if(nums[i]<nums[j]){
                temp[k]=nums[i];
                i++;
            }else{
                temp[k]=nums[j];
                  j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=nums[i];
            i++;
            k++;

        }
        while(j<=end){
            temp[k]=nums[j];
            j++;
            k++;
        }
        for(int p=0;p<temp.length;p++){
            nums[start+p]=temp[p];
        }
    }
}