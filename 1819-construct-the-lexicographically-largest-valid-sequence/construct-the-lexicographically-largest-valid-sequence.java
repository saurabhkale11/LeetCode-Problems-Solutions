class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        dfs(0, res, used, n);
        return res;
    }

    private boolean dfs(int idx, int[] res, boolean[] used, int n) {
        if (idx == res.length) return true;
        if (res[idx] != 0) return dfs(idx + 1, res, used, n);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            if (num == 1) {
                res[idx] = 1;
                used[1] = true;
                if (dfs(idx + 1, res, used, n)) return true;
                res[idx] = 0;
                used[1] = false;
            } else {
                int j = idx + num;
                if (j < res.length && res[j] == 0) {
                    res[idx] = res[j] = num;
                    used[num] = true;
                    if (dfs(idx + 1, res, used, n)) return true;
                    res[idx] = res[j] = 0;
                    used[num] = false;
                }
            }
        }

        return false;
    }
}
