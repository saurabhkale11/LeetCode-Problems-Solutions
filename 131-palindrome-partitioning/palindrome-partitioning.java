import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));  // Found a valid partition, add it to the result
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (isPalindrome(substring)) {  // If the substring is a palindrome
                currentPartition.add(substring);
                backtrack(s, i, currentPartition, result);  // Recurse for the remaining string
                currentPartition.remove(currentPartition.size() - 1);  // Backtrack, remove the last added substring
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
