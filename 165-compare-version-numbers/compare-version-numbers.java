public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len1 = v1.length;
        int len2 = v2.length;
        
        // Compare each corresponding revision
        int i = 0;
        while (i < len1 || i < len2) {
            int num1 = (i < len1) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < len2) ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
            
            i++;
        }
        
        return 0;
    }
}
