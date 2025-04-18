class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            char currentChar = result.charAt(0);
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == currentChar) {
                    count++;
                } else {
                    next.append(count).append(currentChar);
                    currentChar = result.charAt(j);
                    count = 1;
                }
            }
            next.append(count).append(currentChar);
            result = next.toString();
        }
        return result;
    }
}
