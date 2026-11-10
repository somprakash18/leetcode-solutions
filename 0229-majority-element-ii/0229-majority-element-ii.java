class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:map.keySet()){
           if(map.get(num)>n/3){
                res.add(num);
        
           
            }
        }
        return res;
    }
}