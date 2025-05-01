public class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Iterate over all index pairs (i, j) such that i < j
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Check if words[i] is both a prefix and suffix of words[j]
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper function to check if str1 is a prefix and suffix of str2
    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aa"}));  // Output: 4
        System.out.println(solution.countPrefixSuffixPairs(new String[]{"pa", "papa", "ma", "mama"}));  // Output: 2
        System.out.println(solution.countPrefixSuffixPairs(new String[]{"abab", "ab"}));  // Output: 0
    }
}
