import java.util.*;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        List<Integer> ones = new ArrayList<>();
        String ans = "";

        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        if (ones.size() < k) {
            return "";
        }

       
        for (int i = 0; i + k - 1 < ones.size(); i++) {

            int st = ones.get(i);
            int e = ones.get(i + k - 1);

            String curr = s.substring(st, e + 1);

            if (ans.equals("") ||
                curr.length() < ans.length() ||
                (curr.length() == ans.length() &&
                 curr.compareTo(ans) < 0)) {

                ans = curr;
            }
        }

        return ans;
    }
}