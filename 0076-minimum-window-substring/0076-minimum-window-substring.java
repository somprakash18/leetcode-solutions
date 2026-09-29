class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        
        for(int i=0;i<t.length();i++){
           char ch=t.charAt(i);
           map.put(ch,map.getOrDefault(ch ,0)+1);
                
            }
            HashMap<Character,Integer>window=new HashMap<>();
            int left=0;
        int right=0;
        int count=0;
        int minLength=Integer.MAX_VALUE;
        int start=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(map.containsKey(ch)&&window.get(ch)<=map.get(ch)){
                count++;
            }
            right++;
        
        while(count==t.length()){
            if(right-left<minLength){
                minLength=right-left;
                start=left;
            }
            char leftchar=s.charAt(left);
            window.put(leftchar,window.get(leftchar)-1);
            if(map.containsKey(leftchar)&&window.get(leftchar)<map.get(leftchar)){
                count--;
            }
            left++;
        }
        }
        if(minLength==Integer.MAX_VALUE){
          return "";
        }
        return s.substring(start,start+minLength);
       
    }
}