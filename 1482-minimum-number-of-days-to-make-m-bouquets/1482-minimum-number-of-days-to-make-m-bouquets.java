class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        // Total flowers required
        long required = (long) m * k;

        if (required > bloomDay.length) {
            return -1;
        }

        int s = 1;
        int e = 0;

        // Find maximum bloom day
        for (int day : bloomDay) {
            e = Math.max(e, day);
        }

        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            int flowers = 0;
            int bouquets = 0;

            for (int day : bloomDay) {

                if (day <= mid) {
                    flowers++;

                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    // Flowers must be adjacent
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                ans = mid;
                e = mid - 1;       // try fewer days
            } else {
                s = mid + 1;       // need more days
            }
        }

        return ans;
    }
}