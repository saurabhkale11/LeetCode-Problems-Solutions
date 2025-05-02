import java.util.*;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            int count = Math.min(freq[curr], repeatLimit);
            for (int i = 0; i < count; i++) {
                result.append((char) (curr + 'a'));
            }
            freq[curr] -= count;

            if (freq[curr] > 0) {
                if (pq.isEmpty()) break;
                int next = pq.poll();
                result.append((char) (next + 'a'));
                freq[next]--;
                if (freq[next] > 0) pq.offer(next);
                pq.offer(curr);
            }
        }

        return result.toString();
    }
}
