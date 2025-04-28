import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int prime : primes) {
            heap.offer(new long[]{prime, prime, 0});
        }
        for (int i = 1; i < n; i++) {
            ugly[i] = (int) heap.peek()[0];
            while (heap.peek()[0] == ugly[i]) {
                long[] cur = heap.poll();
                heap.offer(new long[]{cur[1] * ugly[(int)cur[2] + 1], cur[1], cur[2] + 1});
            }
        }
        return ugly[n - 1];
    }
}
