public class Solution {
    public String addSpaces(String s, int[] spaces) {
        // Create a StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        
        // Keep track of the last index we processed in the string
        int spaceIndex = 0;
        int spaceCount = spaces.length;
        
        // Loop through the string and insert spaces at the appropriate positions
        for (int i = 0; i < s.length(); i++) {
            // If we need to add a space before this character, add it
            if (spaceIndex < spaceCount && i == spaces[spaceIndex]) {
                result.append(" ");
                spaceIndex++;
            }
            // Append the current character to the result
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}
