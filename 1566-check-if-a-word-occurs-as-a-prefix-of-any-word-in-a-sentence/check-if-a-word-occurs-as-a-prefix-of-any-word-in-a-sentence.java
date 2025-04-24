public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Iterate over each word in the sentence
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with the searchWord
            if (words[i].startsWith(searchWord)) {
                return i + 1;  // Return 1-indexed position
            }
        }
        
        // Return -1 if no word starts with searchWord
        return -1;
    }
}
