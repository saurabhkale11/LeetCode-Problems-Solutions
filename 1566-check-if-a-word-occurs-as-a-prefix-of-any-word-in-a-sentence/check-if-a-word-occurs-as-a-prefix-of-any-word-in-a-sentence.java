public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Iterate over the words in the sentence
        for (int i = 0; i < words.length; i++) {
            // Check if the searchWord is a prefix of the current word
            if (words[i].startsWith(searchWord)) {
                // Return the index (1-indexed)
                return i + 1;
            }
        }
        
        // Return -1 if no word starts with searchWord
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isPrefixOfWord("i love eating burger", "burg")); // Expected: 4
        System.out.println(sol.isPrefixOfWord("this problem is an easy problem", "pro")); // Expected: 2
        System.out.println(sol.isPrefixOfWord("i am tired", "you")); // Expected: -1
    }
}
