public class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length, answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canBecomeZero(nums, queries, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canBecomeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long[] dec = new long[n + 2];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            dec[l] += val;
            dec[r + 1] -= val;
        }

        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += dec[i];
            if (nums[i] > curr) return false;
        }

        return true;
    }
}
