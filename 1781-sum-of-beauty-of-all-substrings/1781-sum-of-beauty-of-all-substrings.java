class Solution {
    public int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
             HashMap<Character,Integer>map=new HashMap<>();
             for(int j=i;j<s.length();j++){
        char ch=s.charAt(j);
        map.put(ch,map.getOrDefault(ch,0)+1);
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int freq:map.values()){
         max=Math.max(freq,max);
         min=Math.min(freq,min);
        
    }
    ans+=max-min;
             }
        }
    return ans;
    }
}