public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;  // Decrease by 1 to make it 0-indexed
            result.append((char) ('A' + columnNumber % 26)); // Get the current letter
            columnNumber /= 26; // Move to the next significant place
        }
        
        return result.reverse().toString(); // Reverse the string to get the correct order
    }
}
