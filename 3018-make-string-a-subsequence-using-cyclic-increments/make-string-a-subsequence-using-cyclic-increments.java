public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Check if str2 is a subsequence of str1 without any operations
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            i++;
        }

        // If str2 is already a subsequence of str1
        if (j == m) {
            return true;
        }

        // Now check if we can transform str1 to match str2 using at most one operation
        i = 0;
        j = 0;
        boolean canMake = false;

        while (i < n && j < m) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(j);
            
            if (char1 == char2) {
                // Characters match, move both pointers
                j++;
            } else if ((char1 + 1 - 'a') % 26 == (char2 - 'a') % 26) {
                // Check if we can increment char1 to match char2
                canMake = true;
                j++;
            }
            i++;
        }

        return canMake && j == m;  // Check if all characters of str2 have been matched
    }
}
