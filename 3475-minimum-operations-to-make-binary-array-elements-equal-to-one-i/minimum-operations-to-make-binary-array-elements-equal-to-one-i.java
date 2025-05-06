class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flipCount = 0;
        int currentFlip = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= 3) currentFlip ^= isFlipped[i - 3];
            if ((nums[i] ^ currentFlip) == 0) {
                if (i + 2 >= n) return -1;
                isFlipped[i] = 1;
                currentFlip ^= 1;
                flipCount++;
            }
        }
        return flipCount;
    }
}
