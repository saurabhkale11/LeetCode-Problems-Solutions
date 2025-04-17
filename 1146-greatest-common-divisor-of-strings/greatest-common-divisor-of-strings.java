class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If str1 + str2 is not equal to str2 + str1, there is no common divisor
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }

        // Find the greatest common divisor of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of str1 up to the GCD length
        return str1.substring(0, gcdLength);
    }

    // Helper method to compute the greatest common divisor (GCD) of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
