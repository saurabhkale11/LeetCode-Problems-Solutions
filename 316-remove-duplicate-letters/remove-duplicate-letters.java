import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peekLast() > c && count[stack.peekLast() - 'a'] > 0) {
                visited[stack.pollLast() - 'a'] = false;
            }
            stack.offerLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
