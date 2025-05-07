import java.util.*;

public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] valIdx = new int[n][2];

        for (int i = 0; i < n; i++) {
            valIdx[i][0] = nums[i];
            valIdx[i][1] = i;
        }

        Arrays.sort(valIdx, (a, b) -> a[0] - b[0]);

        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(valIdx[0][1]);

        for (int i = 1; i < n; i++) {
            if (valIdx[i][0] - valIdx[i - 1][0] <= limit) {
                current.add(valIdx[i][1]);
            } else {
                groups.add(new ArrayList<>(current));
                current.clear();
                current.add(valIdx[i][1]);
            }
        }
        groups.add(current);

        int[] res = new int[n];
        for (List<Integer> group : groups) {
            List<Integer> values = new ArrayList<>();
            for (int idx : group) {
                values.add(nums[idx]);
            }
            Collections.sort(values);
            Collections.sort(group);
            for (int i = 0; i < group.size(); i++) {
                res[group.get(i)] = values.get(i);
            }
        }

        return res;
    }
}
