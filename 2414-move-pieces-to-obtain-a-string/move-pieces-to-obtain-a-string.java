public class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length(), m = target.length();
        while (i < n || j < m) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < m && target.charAt(j) == '_') j++;
            if (i == n && j == m) return true;
            if (i == n || j == m) return false;
            if (start.charAt(i) != target.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
