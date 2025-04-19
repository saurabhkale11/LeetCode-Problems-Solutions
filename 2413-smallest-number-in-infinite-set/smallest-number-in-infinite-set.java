import java.util.*;

public class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> added;

    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        added = new HashSet<>();
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            added.remove(smallest);
            return smallest;
        }
        return current++;
    }

    public void addBack(int num) {
        if (num < current && !added.contains(num)) {
            minHeap.offer(num);
            added.add(num);
        }
    }
}
