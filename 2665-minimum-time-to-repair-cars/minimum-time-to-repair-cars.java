public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long)1e14;
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRepairAll(ranks, cars, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canRepairAll(int[] ranks, int cars, long time) {
        long total = 0;

        for (int r : ranks) {
            total += (long)Math.sqrt(time / r);
            if (total >= cars) return true;
        }

        return false;
    }
}
