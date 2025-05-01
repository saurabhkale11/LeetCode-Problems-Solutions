import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Sort the words by length in ascending order to check substrings efficiently
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further if already found as a substring
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println(sol.stringMatching(new String[]{"mass","as","hero","superhero"}));  // Output: ["as", "hero"]
        System.out.println(sol.stringMatching(new String[]{"leetcode","et","code"}));  // Output: ["et", "code"]
        System.out.println(sol.stringMatching(new String[]{"blue","green","bu"}));  // Output: []
    }
}
