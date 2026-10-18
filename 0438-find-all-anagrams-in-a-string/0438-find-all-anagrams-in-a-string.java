class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result = new ArrayList<>();

        if(s.length()<p.length()){
            return result ;
        }
        int count1[]=new int[26];
        int count2[]=new int[26];
        for(int i=0;i<p.length();i++){
        count1[s.charAt(i)-'a']++;
        count2[p.charAt(i)-'a']++;
        }
        if(java.util.Arrays.equals(count1,count2)){
           result.add(0);
        }
        int left=0;
        for(int right=p.length();right<s.length();right++){
            count2[s.charAt(left)-'a']++;
            count2[s.charAt(right)-'a']--;
            left++;
            if(java.util.Arrays.equals(count1,count2)){
                result.add(left);
            }
        }
        return result;

    }
    
}