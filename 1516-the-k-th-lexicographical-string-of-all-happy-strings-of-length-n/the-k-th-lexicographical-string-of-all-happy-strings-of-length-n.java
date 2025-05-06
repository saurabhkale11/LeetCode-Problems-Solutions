class Solution {
    int count = 0;
    String result = "";
    
    public String getHappyString(int n, int k) {
        dfs(n, k, "", ' ');
        return result;
    }
    
    private void dfs(int n, int k, String current, char lastChar) {
        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current;
            }
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != lastChar && count < k) {
                dfs(n, k, current + ch, ch);
            }
        }
    }
}
