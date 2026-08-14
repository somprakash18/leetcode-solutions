class Solution {
    public int reverse(int digit) {
        int reverse = 0;

        while (digit != 0) {
            int lastDigit = digit % 10;
            digit = digit / 10;

            // Check positive overflow
            if (reverse > Integer.MAX_VALUE / 10 ||
                (reverse == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }

            // Check negative overflow
            if (reverse < Integer.MIN_VALUE / 10 ||
                (reverse == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            reverse = reverse * 10 + lastDigit;
        }

        return reverse;
    }
}