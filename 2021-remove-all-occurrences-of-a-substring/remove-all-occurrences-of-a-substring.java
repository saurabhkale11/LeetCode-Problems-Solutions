public class Solution {
    public String removeOccurrences(String s, String part) {
        // Loop until `part` is no longer a substring of `s`
        while (s.contains(part)) {
            // Find the leftmost occurrence of `part` and remove it
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String s1 = "daabcbaabcbc";
        String part1 = "abc";
        System.out.println(solution.removeOccurrences(s1, part1));  // Output: "dab"
        
        // Example 2
        String s2 = "axxxxyyyyb";
        String part2 = "xy";
        System.out.println(solution.removeOccurrences(s2, part2));  // Output: "ab"
    }
}
