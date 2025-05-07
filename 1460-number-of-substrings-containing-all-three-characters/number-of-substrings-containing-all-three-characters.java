public class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // index 0 = 'a', 1 = 'b', 2 = 'c'
        int res = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += s.length() - r;
                count[s.charAt(l) - 'a']--;
                l++;
            }
        }

        return res;
    }
}
