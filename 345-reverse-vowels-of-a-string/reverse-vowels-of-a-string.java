class Solution {
    public String reverseVowels(String s) {
        // Define a set of vowels for quick lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        // Use two pointers to swap vowels
        while (left < right) {
            // Find the next vowel from the left
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Find the next vowel from the right
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                // Move the pointers inward
                left++;
                right--;
            }
        }

        // Convert the character array back to string
        return new String(chars);
    }
}
