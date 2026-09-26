class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
            
            int d=i-map.get(nums[i]);
            if(d<=k){
                return true;
            }
           
            }
            map.put(nums[i],i);
        }
        return false;
    }
}