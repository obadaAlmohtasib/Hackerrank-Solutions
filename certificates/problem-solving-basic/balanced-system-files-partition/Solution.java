import java.util.*;

public class Solution {
    
    public static void main(String[] args) 
    {
    // Test case #1: parent (-1, 0, 0, 1, 1, 2), files_size (1, 2, 2, 1, 1, 1)
    // Test case #2: parent (-1, 0, 1, 2), files_size (1, 4, 3, 4)
    // Test case #3: parent (-1, 0, 0, 0), files_size (10, 11, 10, 10)
    
        List<Integer> parent = Arrays.asList(-1, 0, 0, 1, 1, 2);
        List<Integer> files_size = Arrays.asList(1, 2, 2, 1, 1, 1);
        int min = mostBalancedPartition(parent, files_size);
        System.out.println("Min Diff: " + min);
    }
    
    
    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) 
    {
        int min = Integer.MAX_VALUE;
        
        // 1) Sum of all the child nodes with parent values.
        int[] sums = new int[parent.size()];
        for (int i=parent.size()-1; i>=0; i--) {
            sums[i] += files_size.get(i);
            int parentOfI = parent.get(i);
            if (parentOfI >= 0) {
            //  Add the cumulative value to the parent   
                sums[parentOfI] += sums[i];
            }
        }
        
        int[] diff = new int[sums.length];
        for (int i=0; i<sums.length; i++) {
            // Cutting the branch
            diff[i] = sums[0] - sums[i];
        }
        
        for (int i=0; i<sums.length; i++) {
            // Seeking for most balanced partition value
            if (Math.abs(sums[i] - diff[i]) < min) {
                min = Math.abs(sums[i] - diff[i]);   
            }
        }
        
        // We can cleaning the above two loop by combining the loop operation in one statement, Since the Diff[i] = sums[0] - sums[i];
        // for (int i=0; i<sums.length; i++) {
        //     min = Math.min(Math.abs(sums[0] - sums[i]*2), min);   
        // }
        return min;
    }
    
}
