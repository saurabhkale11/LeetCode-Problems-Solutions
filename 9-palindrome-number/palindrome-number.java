public class Solution {
    public boolean isPalindrome(int x) {
        // If the number is negative or ends with 0 but isn't 0, it's not a palindrome.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Check if the first half is equal to the reversed second half
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
