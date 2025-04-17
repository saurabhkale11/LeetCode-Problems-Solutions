import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number (could be multiple digits)
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // Push current number and string onto their respective stacks
                countStack.push(currentNum);
                stack.push(currentString.toString());
                currentString = new StringBuilder(); // Reset current string
                currentNum = 0; // Reset current number
            } else if (c == ']') {
                // Pop the number and string, and repeat the current string
                int repeatCount = countStack.pop();
                String prevString = stack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(currentString);
                }
                currentString = new StringBuilder(prevString).append(temp);
            } else {
                // Append current character to the string
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
