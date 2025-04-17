public class Solution {
    public int maxVowels(String s, int k) {
        // Define the set of vowel characters
        String vowels = "aeiou";
        int maxVowelCount = 0;
        int currentVowelCount = 0;

        // Initialize the first window (first 'k' characters)
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowelCount++;
            }
        }

        maxVowelCount = currentVowelCount;

        // Sliding window to check the remaining substrings of length 'k'
        for (int i = k; i < s.length(); i++) {
            // Remove the vowel contribution from the left of the window
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowelCount--;
            }
            // Add the vowel contribution from the new character on the right
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowelCount++;
            }

            // Update the maxVowelCount if the current window has more vowels
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }

        return maxVowelCount;
    }
}
