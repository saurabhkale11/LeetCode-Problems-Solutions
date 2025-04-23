import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) {
            return 0;  // If endWord is not in wordList, no valid transformation sequence
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;  // Starting level is 1 because beginWord itself counts as the first word in the sequence

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try all possible transformations
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArr = currentWord.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String nextWord = new String(wordArr);

                        // If the transformed word is in the word list and not visited yet
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return level + 1;  // Return level + 1 when endWord is found
                            }
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            level++;  // Increment level after processing the current level of words
        }
        
        return 0;  // If no transformation sequence exists
    }
}
