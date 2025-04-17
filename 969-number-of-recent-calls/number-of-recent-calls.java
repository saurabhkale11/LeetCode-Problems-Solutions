import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);  // Add the new request
        // Remove requests that are outside the 3000 ms window
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();  // Return the number of requests in the window
    }
}
