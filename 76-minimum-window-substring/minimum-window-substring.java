public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        int[] target = new int[256];
        for (char c : t.toCharArray()) {
            target[c]++;
        }

        // Sliding window approach
        int[] window = new int[256];
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int count = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            window[rightChar]++;
            
            // If current window contains enough of rightChar
            if (window[rightChar] <= target[rightChar]) {
                count++;
            }

            // When the window is valid (contains all characters from t)
            while (count == t.length()) {
                // Update the minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Shrink the window from the left
                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (window[leftChar] < target[leftChar]) {
                    count--;
                }
                left++;
            }
            right++;
        }

        // If no valid window found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
