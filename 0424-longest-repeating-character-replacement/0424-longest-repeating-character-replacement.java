class Solution {
    public int characterReplacement(String s, int k) {
         int count[]=new int[26];
        int left=0;
        int maxf=0;
        int maxL=0;
        for(int right=0;right<s.length();right++){
           count[s.charAt(right)-'A']++;
           maxf=Math.max(count[s.charAt(right)-'A'],maxf);
           while(right-left+1-maxf>k){
            count[s.charAt(left)-'A']--;
            left++;
           }
           maxL=Math.max(maxL,right-left+1);
        }
        return maxL;
    }
}