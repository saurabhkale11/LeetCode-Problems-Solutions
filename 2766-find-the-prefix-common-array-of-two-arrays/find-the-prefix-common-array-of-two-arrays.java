import java.util.*;

public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            // Calculate the intersection size at this point
            Set<Integer> common = new HashSet<>(setA);
            common.retainAll(setB);
            C[i] = common.size();
        }
        
        return C;
    }
}
