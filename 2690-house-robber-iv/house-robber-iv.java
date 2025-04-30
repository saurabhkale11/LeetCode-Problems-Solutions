public class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canRob(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canRob(int[] nums, int k, int maxCap) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= maxCap) {
                count++;
                i += 2; // skip adjacent house
            } else {
                i++;
            }
        }

        return count >= k;
    }
}
