class Solution {
    public int characterReplacement(String s, int k) {
         int max=0;
         int i=0,j=0;
         int maxC=0;
         int[]counts=new int[26];
         while(j<s.length()){
            char c=s.charAt(j);
            counts[c-'A']=counts[c-'A']+1;
            maxC=Math.max(maxC,counts[c-'A']);
            
            while((j-i+1)-maxC>k){
                char d=s.charAt(i);
                counts[d-'A']=counts[d-'A']-1;
                i=i+1;
                for(int l=0;l<26;l=l+1){
                    maxC=Math.max(maxC,counts[l]);
                }
            }
            max=Math.max(max,j-i+1);
            j=j+1;
         }
         return max;

    }
}