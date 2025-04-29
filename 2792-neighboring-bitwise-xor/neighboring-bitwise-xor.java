public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        // Let's try assuming original[0] = 0
        int[] original = new int[n];
        original[0] = 0;

        // Calculate all other elements of original
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }

        // Now check the condition for the last element
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
