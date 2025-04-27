import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        // If the input is empty, return an empty list
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        // Mapping of digits to letters
        String[] digitToLetters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] digitToLetters) {
        // If the current combination has the same length as the input digits, it's a valid combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = digitToLetters[digits.charAt(index) - '0'];
        
        // Explore all possible letters for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Add the letter to the current combination
            backtrack(digits, index + 1, current, result, digitToLetters);  // Recur for the next digit
            current.deleteCharAt(current.length() - 1);  // Remove the last added letter for backtracking
        }
    }
}
