import java.util.*;

class Solution {

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> set = new HashSet<>();

            boolean isPos = nums[i] > 0;

            int curr = i;

            while (true) {

                int next = calcNextIdx(nums, curr);

                // Direction changes
                if (isPos) {
                    if (nums[next] < 0) {
                        break;
                    }
                } else {
                    if (nums[next] > 0) {
                        break;
                    }
                }

                // Self loop is not allowed
                if (next == curr) {
                    break;
                }

                // Cycle found
                if (set.contains(next)) {
                    return true;
                }

                set.add(curr);

                curr = next;
            }
        }

        return false;
    }

    public int calcNextIdx(int[] nums, int curr) {

        int n = nums.length;

        int next = (curr + nums[curr]) % n;

        // Handle negative index
        if (next < 0) {
            next += n;
        }

        return next;
    }
}