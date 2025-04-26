class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = -1, count = 0;
        for (int num : nums) {
            if (count == 0) dominant = num;
            count += num == dominant ? 1 : -1;
        }
        int total = 0;
        for (int num : nums) {
            if (num == dominant) total++;
        }
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) left++;
            if (left * 2 > i + 1 && (total - left) * 2 > n - i - 1) return i;
        }
        return -1;
    }
}
