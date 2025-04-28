class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0, sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}
