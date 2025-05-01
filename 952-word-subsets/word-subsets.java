import java.util.*;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        // Count the maximum frequency of each character required by any word in words2
        int[] maxFreq = new int[26]; // Array to store max frequency of each character ('a' = 0, 'z' = 25)
        
        for (String word : words2) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], wordFreq[i]);
            }
        }

        // Now check each word in words1
        for (String word : words1) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }

            // Check if the word contains the necessary frequencies for each character
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));  // Output: ["facebook", "google", "leetcode"]
        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lc", "eo"}));  // Output: ["leetcode"]
        System.out.println(solution.wordSubsets(new String[]{"acaac", "cccbb", "aacbb", "caacc", "bcbbb"}, new String[]{"c", "cc", "b"}));  // Output: ["cccbb"]
    }
}
