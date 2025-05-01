public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        // Iterate through the words array and check if each word starts with the prefix
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));  // Output: 2
        System.out.println(solution.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));  // Output: 0
    }
}
