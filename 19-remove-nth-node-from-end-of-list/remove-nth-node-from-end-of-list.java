public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        // Move the first pointer n+1 steps ahead.
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move both pointers until the first reaches the end.
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end.
        second.next = second.next.next;

        return dummy.next;
    }
}
