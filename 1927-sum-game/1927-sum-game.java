class Solution {
    public boolean sumGame(String num) {

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        int n = num.length();

        // Left half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        // Right half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        // If total number of '?' is odd, Alice always wins
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }

        /*
         * Bob can make both sums equal only when:
         *
         * leftSum - rightSum == 9 * (rightQ - leftQ) / 2
         *
         * If this condition is true -> Bob wins -> return false
         * Otherwise Alice wins -> return true
         */

        return 2 * (leftSum - rightSum) != 9 * (rightQ - leftQ);
    }
}