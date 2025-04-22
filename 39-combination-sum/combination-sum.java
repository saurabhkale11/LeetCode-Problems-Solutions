import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }
        path.add(candidates[index]);
        dfs(candidates, target - candidates[index], index, path, result);
        path.remove(path.size() - 1);
        dfs(candidates, target, index + 1, path, result);
    }
}
