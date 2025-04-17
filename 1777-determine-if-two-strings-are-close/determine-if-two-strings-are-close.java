class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] count1 = new int[26], count2 = new int[26];
        boolean[] seen1 = new boolean[26], seen2 = new boolean[26];

        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
            seen1[word1.charAt(i) - 'a'] = true;
            seen2[word2.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (seen1[i] != seen2[i]) return false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }

        return true;
    }
}
