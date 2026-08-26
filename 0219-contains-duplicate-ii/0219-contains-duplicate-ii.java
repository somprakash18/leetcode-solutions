class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<Math.min(k,nums.length);i=i+1){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        for(int i=k;i<nums.length;i=i+1){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            set.remove(nums[i-k]);
        }
        return false;
    }
}