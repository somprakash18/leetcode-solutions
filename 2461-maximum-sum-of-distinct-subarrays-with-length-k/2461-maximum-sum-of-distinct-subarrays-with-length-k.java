import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        long sum = 0;
        long max = 0;

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            // Remove duplicate from the left
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // Add current element
            set.add(nums[j]);
            sum += nums[j];

            // Window size becomes greater than k
            if (j - i + 1 > k) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // If window size is exactly k
            if (j - i + 1 == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}