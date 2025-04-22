import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, "", result, 0);
        return result;
    }
    
    private void backtrack(String s, int start, String current, List<String> result, int dotCount) {
        if (dotCount == 3) {
            String part = s.substring(start);
            if (isValid(part)) {
                result.add(current + "." + part);
            }
            return;
        }
        
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String part = s.substring(start, start + len);
            if (isValid(part)) {
                backtrack(s, start + len, current + (dotCount == 0 ? "" : ".") + part, result, dotCount + 1);
            }
        }
    }
    
    private boolean isValid(String part) {
        if (part.isEmpty()) {
            return false;  // Avoid processing empty parts
        }
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;  // Invalid part with leading zero (except for "0")
        }
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}
