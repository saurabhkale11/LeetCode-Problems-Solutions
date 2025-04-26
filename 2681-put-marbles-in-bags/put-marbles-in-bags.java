class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> pairSums = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) pairSums.add(weights[i] + weights[i + 1]);
        Collections.sort(pairSums);
        long minScore = 0, maxScore = 0;
        for (int i = 0; i < k - 1; i++) minScore += pairSums.get(i);
        for (int i = 0; i < k - 1; i++) maxScore += pairSums.get(pairSums.size() - 1 - i);
        return maxScore - minScore;
    }
}
