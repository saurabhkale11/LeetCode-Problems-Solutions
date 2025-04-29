public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0;
        int n = s.length();
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            // Check if the current index matches any space index
            while (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                result.append(' ');  // Add a space before the character
                spaceIndex++;  // Move to the next space index
            }
            result.append(s.charAt(i));  // Add the current character
        }
        
        return result.toString();  // Convert StringBuilder to string and return
    }
}
