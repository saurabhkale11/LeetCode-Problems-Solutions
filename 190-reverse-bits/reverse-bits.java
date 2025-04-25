public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1); // Shift result left and add the least significant bit of n
            n >>= 1; // Shift n right to move to the next bit
        }
        return result;
    }
}
