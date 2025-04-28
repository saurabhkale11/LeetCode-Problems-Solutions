class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        
        // Shift left and right until they are the same
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        
        // Left-shift the result to get the final bitwise AND of the range
        return left << shift;
    }
}
