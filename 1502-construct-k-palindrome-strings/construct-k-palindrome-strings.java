import java.util.*;

public class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Count how many characters have odd frequency
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                oddCount++;
            }
        }
        
        // For k palindromes to be possible, we need at least k characters
        // and at most k odd characters.
        return oddCount <= k && s.length() >= k;
    }
}
