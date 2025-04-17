public class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                result.deleteCharAt(result.length() - 1); // Remove the last character
            } else {
                result.append(ch); // Add the character to the result
            }
        }
        
        return result.toString();
    }
}
