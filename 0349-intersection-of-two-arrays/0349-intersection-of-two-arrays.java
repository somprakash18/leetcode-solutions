class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
                if(nums1[i]<nums2[j]){
                    i++;
                }
                else if(nums1[i]>nums2[j]){
                    j++;
                }
                else{
                     if (k == 0 || temp[k - 1] != nums1[i]) {
                    temp[k] = nums1[i];
                    k++;
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOf(temp, k);
    }
}