public class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;

        int open = 0, free = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                open += s.charAt(i) == '(' ? 1 : -1;
            } else {
                free++;
                open++;
            }
            if (open < 0) return false;
        }

        open = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                open += s.charAt(i) == ')' ? 1 : -1;
            } else {
                open++;
            }
            if (open < 0) return false;
        }

        return true;
    }
}
