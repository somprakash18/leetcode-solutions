class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=0;
        int sum=0;
        for(int x:nums){
            max=Math.max(max,x);
            sum+=x;
        }
        return max*n-sum;
    }
}