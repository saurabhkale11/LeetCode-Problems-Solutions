import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        // Step 1: Sort the products lexicographically
        Arrays.sort(products);
        
        // Step 2: For each prefix of searchWord, find the matching products
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;  // build the prefix incrementally
            List<String> suggestions = new ArrayList<>();
            
            // Step 3: Find all products with the current prefix
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                }
                if (suggestions.size() == 3) {
                    break;  // Stop after collecting 3 products
                }
            }
            
            // Step 4: Add the suggestions to the result
            result.add(suggestions);
        }
        
        return result;
    }
}
