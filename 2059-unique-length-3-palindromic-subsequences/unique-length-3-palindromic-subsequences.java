public class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = -1, last = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    if (first == -1) first = i;
                    last = i;
                }
            }
            if (first != -1 && last != -1 && last - first > 1) {
                boolean[] middle = new boolean[26];
                for (int i = first + 1; i < last; i++) {
                    middle[s.charAt(i) - 'a'] = true;
                }
                for (boolean seen : middle) {
                    if (seen) result++;
                }
            }
        }

        return result;
    }
}
