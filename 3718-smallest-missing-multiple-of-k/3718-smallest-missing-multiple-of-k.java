class Solution {
    public int missingMultiple(int[] nums, int k) {

        int n = nums.length;

        int[] arr = new int[102];

        for (int i : nums) {
            if (i % k == 0) {
                int x = i / k;
                arr[x] = 1;
            }
        }

        int ans = 0;

        for (int i = 1; i <= 101; i++) {
            if (arr[i] == 0) {
                ans = k * i;
                break;
            }
        }

        return ans;
    }
}