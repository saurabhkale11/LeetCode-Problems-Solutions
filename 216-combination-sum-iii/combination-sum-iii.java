import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int n, int start) {
        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (current.size() >= k || n <= 0) return;

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, k, n - i, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
