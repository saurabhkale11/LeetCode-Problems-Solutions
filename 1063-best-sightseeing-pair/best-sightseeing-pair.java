public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0] + 0;
        int result = 0;

        for (int j = 1; j < values.length; j++) {
            result = Math.max(result, max + values[j] - j);
            max = Math.max(max, values[j] + j);
        }

        return result;
    }
}
