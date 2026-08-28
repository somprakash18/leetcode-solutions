class Solution {
    
    char midChar = '$';
    int halfLen = 0;
    String result = "";

    boolean solve(StringBuilder curr, int[] count, String target,
                  int i, boolean greater) {

        // Base case
        if (curr.length() == halfLen) {

            String leftHalf = curr.toString();

            String rightHalf =
                    new StringBuilder(leftHalf).reverse().toString();

            String candidate;

            if (midChar != '$') {
                candidate = leftHalf + midChar + rightHalf;
            } else {
                candidate = leftHalf + rightHalf;
            }

            if (candidate.compareTo(target) > 0) {
                result = candidate;
                return true;
            }

            return false;
        }

        // Try all characters
        for (char ch = 'a'; ch <= 'z'; ch++) {

            if (count[ch - 'a'] == 0) {
                continue;
            }

            if (!greater && i < target.length()
                    && ch < target.charAt(i)) {
                continue;
            }

            // Choose
            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater ||
                    (i < target.length()
                            && ch > target.charAt(i));

            // Recursive call
            if (solve(curr, count, target, i + 1, isGreater)) {
                return true;
            }

            // Backtracking
            curr.deleteCharAt(curr.length() - 1);
            count[ch - 'a']++;
        }

        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] count = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;

        // Find middle character
        for (int c = 0; c < 26; c++) {

            if (count[c] % 2 == 1) {
                oddCount++;
                midChar = (char) ('a' + c);
            }
        }

        // More than one odd frequency -> impossible
        if (oddCount > 1) {
            return "";
        }

        // We only need half characters
        for (int c = 0; c < 26; c++) {
            count[c] /= 2;
        }

        halfLen = n / 2;

        StringBuilder curr = new StringBuilder();

        solve(curr, count, target, 0, false);

        return result;
    }
}