public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int val = direction == 1 ? 1 : -1;

            delta[start] += val;
            if (end + 1 < n) {
                delta[end + 1] -= val;
            }
        }

        int[] shiftAmount = new int[n];
        shiftAmount[0] = delta[0];
        for (int i = 1; i < n; i++) {
            shiftAmount[i] = shiftAmount[i - 1] + delta[i];
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int shifted = (c + shiftAmount[i]) % 26;
            if (shifted < 0) shifted += 26;
            result.append((char) (shifted + 'a'));
        }

        return result.toString();
    }
}
