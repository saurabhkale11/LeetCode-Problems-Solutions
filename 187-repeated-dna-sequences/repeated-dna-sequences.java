import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // Sliding window to extract each 10-length substring
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        
        // Collect all substrings that appear more than once
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }
        
        return result;
    }
}
