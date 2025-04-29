import java.util.*;

public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Convert banned array to a set for faster lookup
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        // Collect all integers in range [1, n] that are not in bannedSet
        List<Integer> validNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i)) {
                validNumbers.add(i);
            }
        }

        // Sort valid numbers to pick the smallest ones first
        Collections.sort(validNumbers);

        // Try to select the numbers in increasing order until maxSum is exceeded
        int sum = 0;
        int count = 0;
        for (int num : validNumbers) {
            if (sum + num <= maxSum) {
                sum += num;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
