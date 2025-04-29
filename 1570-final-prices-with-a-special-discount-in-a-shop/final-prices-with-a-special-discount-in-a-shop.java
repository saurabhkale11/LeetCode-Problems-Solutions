import java.util.*;

public class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop all elements from the stack that are greater than the current price
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                stack.pop();
            }
            
            // If stack is not empty, the element at the top of the stack is the discount
            if (!stack.isEmpty()) {
                answer[i] = prices[i] - prices[stack.peek()];
            } else {
                // No discount
                answer[i] = prices[i];
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return answer;
    }
}
