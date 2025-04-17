public class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        // Iterate through each bit position from 0 to 30 (because max number is 10^9, which is less than 2^30)
        for (int i = 0; i < 30; i++) {
            // Extract the i-th bit of a, b, and c
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;
            int c_bit = (c >> i) & 1;
            
            if (c_bit == 0) {
                // If c_bit is 0, both a_bit and b_bit must be 0. If not, flip is needed.
                if (a_bit == 1) flips++;
                if (b_bit == 1) flips++;
            } else {
                // If c_bit is 1, at least one of a_bit or b_bit must be 1. If both are 0, flip is needed.
                if (a_bit == 0 && b_bit == 0) flips++;
            }
        }
        
        return flips;
    }
}
