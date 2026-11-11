class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);

        // Count reverse pairs
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - mid - 1;
        }

        // Sort the two halves
        Arrays.sort(nums, left, right + 1);

        return count;
    }
}