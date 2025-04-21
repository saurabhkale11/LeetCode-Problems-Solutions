public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        // Traverse both linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous addition
            
            // Add current digits from l1 and l2 if they exist
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Calculate new carry and the current digit
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummyHead.next; // Return the next of dummy node which is the head of the result
    }
}
