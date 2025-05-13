import java.util.*;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (i >= k) curSum -= nums[i - k];
            if (i >= k - 1) sum[i - k + 1] = curSum;
        }

        int[] left = new int[sum.length];
        int bestLeft = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[bestLeft]) bestLeft = i;
            left[i] = bestLeft;
        }

        int[] right = new int[sum.length];
        int bestRight = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[bestRight]) bestRight = i;
            right[i] = bestRight;
        }

        int maxTotal = 0;
        int[] res = new int[3];
        for (int mid = k; mid < sum.length - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = sum[l] + sum[mid] + sum[r];
            if (total > maxTotal) {
                maxTotal = total;
                res[0] = l;
                res[1] = mid;
                res[2] = r;
            }
        }

        return res;
    }
}
