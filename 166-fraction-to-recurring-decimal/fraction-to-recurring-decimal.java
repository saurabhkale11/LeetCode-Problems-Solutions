import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Handle the case where the result is 0
        if (numerator == 0) return "0";

        // Determine the sign of the result
        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values to avoid sign issues
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Add the integer part
        result.append(num / denom);
        long remainder = num % denom;

        // If there is no fractional part
        if (remainder == 0) {
            return result.toString();
        }

        // Add the decimal point
        result.append(".");

        // Map to store the first occurrence of each remainder
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        
        // Process the fractional part
        while (remainder != 0) {
            // If we have seen this remainder before, we have a repeating decimal
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            }

            // Record the position of this remainder
            remainderMap.put(remainder, result.length());

            // Long division: multiply remainder by 10
            remainder *= 10;
            result.append(remainder / denom);
            remainder = remainder % denom;
        }

        return result.toString();
    }
}
