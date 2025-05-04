import java.util.*;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            // Sort the domino to get the canonical representation
            String key = domino[0] < domino[1] ? domino[0] + "," + domino[1] : domino[1] + "," + domino[0];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Count the number of valid pairs
        for (int freq : map.values()) {
            count += (freq * (freq - 1)) / 2;
        }

        return count;
    }
}
