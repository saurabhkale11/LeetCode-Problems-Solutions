public class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[nums2[i]] = i;

        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) transformed[i] = pos[nums1[i]];

        FenwickTree leftTree = new FenwickTree(n);
        FenwickTree rightTree = new FenwickTree(n);
        int[] countRight = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            countRight[i] = rightTree.query(n - 1) - rightTree.query(transformed[i]);
            rightTree.update(transformed[i], 1);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int countLeft = leftTree.query(transformed[i] - 1);
            ans += (long) countLeft * countRight[i];
            leftTree.update(transformed[i], 1);
        }

        return ans;
    }

    class FenwickTree {
        int[] bit;
        int n;

        FenwickTree(int size) {
            n = size;
            bit = new int[n + 1];
        }

        void update(int i, int delta) {
            for (i++; i <= n; i += i & -i) bit[i] += delta;
        }

        int query(int i) {
            int sum = 0;
            for (i++; i > 0; i -= i & -i) sum += bit[i];
            return sum;
        }
    }
}
