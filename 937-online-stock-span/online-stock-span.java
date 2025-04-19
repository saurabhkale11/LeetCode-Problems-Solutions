import java.util.Stack;

class StockSpanner {
    // Stack to store pairs of (price, span)
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;  // Start with a span of 1 (current day)
        
        // Calculate the span by popping from the stack until we find a price greater than the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];  // Add the span of the popped element
        }
        
        // Push the current price and its span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}
