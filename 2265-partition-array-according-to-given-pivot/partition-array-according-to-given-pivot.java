public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // Lists to store elements less than, equal to, and greater than pivot
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        
        // Categorize elements based on their relation to pivot
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }
        
        // Concatenate the lists: less, equal, greater
        List<Integer> result = new ArrayList<>();
        result.addAll(less);
        result.addAll(equal);
        result.addAll(greater);
        
        // Convert the result list to an array and return it
        int[] resArray = new int[nums.length];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        
        return resArray;
    }
}
