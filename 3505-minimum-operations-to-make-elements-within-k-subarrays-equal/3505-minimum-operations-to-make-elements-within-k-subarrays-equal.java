
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize = 0, highSize = 0;
    long sumLow = 0, sumHigh = 0;

    void add(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int v) {
        if (map.get(v) == 1) map.remove(v);
        else map.put(v, map.get(v) - 1);
    }

    void balance() {
        int target = (lowSize + highSize + 1) / 2;

        while (lowSize > target) {
            int v = low.lastKey();
            remove(low, v);
            lowSize--;
            sumLow -= v;

            add(high, v);
            highSize++;
            sumHigh += v;
        }

        while (lowSize < target) {
            int v = high.firstKey();
            remove(high, v);
            highSize--;
            sumHigh -= v;

            add(low, v);
            lowSize++;
            sumLow += v;
        }
    }

    void insert(int v) {
        if (lowSize == 0 || v <= low.lastKey()) {
            add(low, v);
            lowSize++;
            sumLow += v;
        } else {
            add(high, v);
            highSize++;
            sumHigh += v;
        }
        balance();
    }

    void erase(int v) {
        if (low.containsKey(v)) {
            remove(low, v);
            lowSize--;
            sumLow -= v;
        } else {
            remove(high, v);
            highSize--;
            sumHigh -= v;
        }
        balance();
    }

    long getCost() {
        long median = low.lastKey();

        return median * lowSize - sumLow
             + sumHigh - median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        low.clear();
        high.clear();
        lowSize = highSize = 0;
        sumLow = sumHigh = 0;

        long[] cost = new long[n - x + 1];

        // Calculate first window
        for (int i = 0; i < x; i++) {
            insert(nums[i]);
        }

        cost[0] = getCost();

        // Calculate remaining windows
        for (int i = x; i < n; i++) {
            erase(nums[i - x]);
            insert(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Skip current element
                curr[i] = curr[i - 1];

                // Select a window
                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
