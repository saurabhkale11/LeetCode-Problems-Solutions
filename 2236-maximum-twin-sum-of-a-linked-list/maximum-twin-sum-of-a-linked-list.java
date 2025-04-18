class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        
        // Step 1: Find the middle of the list using the slow and fast pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Step 3: Compare the first and second half and calculate the maximum twin sum
        int maxSum = 0;
        ListNode first = head, second = prev;
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        
        return maxSum;
    }
}
