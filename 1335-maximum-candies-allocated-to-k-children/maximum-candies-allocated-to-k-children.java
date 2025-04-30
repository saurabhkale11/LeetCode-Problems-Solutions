public class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = (int)1e7;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canServe(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canServe(int[] candies, long k, int x) {
        long count = 0;
        for (int c : candies) {
            count += c / x;
            if (count >= k) return true;
        }
        return false;
    }
}
