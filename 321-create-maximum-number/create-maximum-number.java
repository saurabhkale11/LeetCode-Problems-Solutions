import java.util.*;

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i));
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }
    
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && res[j - 1] < nums[i] && j + n - i > k) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n + m];
        int i = 0, j = 0, r = 0;
        while (i < n || j < m) {
            if (greater(nums1, i, nums2, j)) {
                res[r++] = nums1[i++];
            } else {
                res[r++] = nums2[j++];
            }
        }
        return res;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length, m = nums2.length;
        while (i < n && j < m && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == m || (i < n && nums1[i] > nums2[j]);
    }
}
