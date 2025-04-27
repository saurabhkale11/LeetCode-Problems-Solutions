public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the area with the current pair of lines
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            
            // Update the maximum area
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer corresponding to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
