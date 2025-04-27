import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLength(String s) {
        Map<Character, int[]> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == ch) {
                j++;
            }
            int len = j - i;
            map.putIfAbsent(ch, new int[100001]);
            for (int l = 1; l <= len; l++) {
                map.get(ch)[l] += len - l + 1;
            }
            i = j;
        }

        int ans = -1;
        for (int[] freq : map.values()) {
            for (int l = freq.length - 1; l >= 1; l--) {
                if (freq[l] >= 3) {
                    ans = Math.max(ans, l);
                    break;
                }
            }
        }
        return ans;
    }
}
