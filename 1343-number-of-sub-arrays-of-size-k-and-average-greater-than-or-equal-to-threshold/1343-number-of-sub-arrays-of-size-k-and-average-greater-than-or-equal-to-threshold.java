class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int maxT=k*threshold;
        for(int i=0;i<k;i=i+1){
            sum=sum+arr[i];
        }
        int count=0;
        if(sum>=maxT){
            count=count+1;
        }
        for(int i=k;i<arr.length;i=i+1){
            sum=sum+arr[i];
            sum=sum-arr[i-k];
            if(sum>=maxT){
                count=count+1;
            }
        }
        return count;
    }
}