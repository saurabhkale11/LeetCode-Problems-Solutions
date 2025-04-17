class Trie {
    // TrieNode class to represent each node in the Trie
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode() {
            this.children = new TrieNode[26]; // 26 letters in the English alphabet
            this.isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Constructor to initialize the root of the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Insert the word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Convert char to index (0 for 'a', 1 for 'b', etc.)
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            }
            node = node.children[index]; // Move to the next node
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    // Search if the word is in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false; // If at any point, the next character is not found
            }
            node = node.children[index];
        }
        return node.isEndOfWord; // Return true if it's the end of the word
    }

    // Check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false; // If at any point, the prefix is not found
            }
            node = node.children[index];
        }
        return true; // Return true if prefix is found
    }
}
