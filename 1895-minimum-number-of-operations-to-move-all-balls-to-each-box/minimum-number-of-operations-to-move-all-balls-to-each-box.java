public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int count = 0, steps = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += steps;
            if (boxes.charAt(i) == '1') count++;
            steps += count;
        }

        count = 0;
        steps = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += steps;
            if (boxes.charAt(i) == '1') count++;
            steps += count;
        }

        return answer;
    }
}
