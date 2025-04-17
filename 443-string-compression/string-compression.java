public class Solution {
    public int compress(char[] chars) {
        int write = 0, read = 0;
        
        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;
            
            // Count the number of occurrences of the current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }
            
            // Write the current character
            chars[write++] = currentChar;
            
            // If the character occurs more than once, write the count
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }
        
        return write;
    }
}
