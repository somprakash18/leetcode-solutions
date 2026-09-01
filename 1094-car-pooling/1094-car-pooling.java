class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer>map=new TreeMap<>();
        for(int[]trip:trips){
            int pass=trip[0],
            start=trip[1],end=trip[2];
            map.put(start,map.getOrDefault(start,0)+pass);
            map.put(end,map.getOrDefault(end,0)-pass);
        }
        int passengers=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
          passengers=passengers+entry.getValue();
          if(passengers>capacity){
            return false;
          }
        }
        return true;
    }
}