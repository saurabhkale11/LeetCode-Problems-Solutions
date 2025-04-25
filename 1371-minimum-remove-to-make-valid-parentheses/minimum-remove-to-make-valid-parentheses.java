public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;
        
        // First pass: remove invalid closing parentheses ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
                result.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        
        // Second pass: remove invalid opening parentheses '('
        StringBuilder finalResult = new StringBuilder();
        openCount = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);
            if (c == ')') {
                openCount++;
                finalResult.append(c);
            } else if (c == '(') {
                if (openCount > 0) {
                    openCount--;
                    finalResult.append(c);
                }
            } else {
                finalResult.append(c);
            }
        }
        
        return finalResult.reverse().toString();
    }
}
