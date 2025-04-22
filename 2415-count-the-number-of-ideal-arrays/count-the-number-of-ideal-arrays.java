import java.util.*;

public class Solution {
    public int idealArrays(int n, int maxValue) {
        int MOD = 1_000_000_007;
        int maxLen = 14;

        int[][] comb = new int[n + 1][maxLen + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= maxLen && j <= i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        Map<Integer, List<Integer>> divisors = new HashMap<>();
        for (int i = 1; i <= maxValue; i++) {
            divisors.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= maxValue; i++) {
            for (int j = i * 2; j <= maxValue; j += i) {
                divisors.get(j).add(i);
            }
        }

        int[][] dp = new int[maxLen + 1][maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int d : divisors.get(i)) {
                    dp[len][i] = (dp[len][i] + dp[len - 1][d]) % MOD;
                }
            }
        }

        long res = 0;
        for (int len = 1; len <= maxLen && len <= n; len++) {
            for (int i = 1; i <= maxValue; i++) {
                res = (res + 1L * dp[len][i] * comb[n - 1][len - 1]) % MOD;
            }
        }

        return (int) res;
    }
}
