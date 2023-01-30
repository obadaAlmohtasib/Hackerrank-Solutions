import java.util.*;

public class Solution {
    
    public static void main(String[] args) 
    {
    // Test case #1: parent (-1, 0, 0, 1, 1, 2), files_size (1, 2, 2, 1, 1, 1)
    // Test case #2: parent (-1, 0, 1, 2), files_size (1, 4, 3, 4)
    // Test case #3: parent (-1, 0, 0, 0), files_size (10, 11, 10, 10)
    
        List<Integer> parent = Arrays.asList(-1, 0, 0, 0);
        List<Integer> files_size = Arrays.asList(10, 11, 10, 10);
        int min = mostBalancedPartition(parent, files_size);
        System.out.println("Min Diff: " + min);
    }
    
    
    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) 
    {
        int min = Integer.MAX_VALUE;
        
        int[] sums = new int[parent.size()];
        for (int i=parent.size()-1; i>=0; i--) {
            sums[i] += files_size.get(i);
            int parentOfI = parent.get(i);
            if (parentOfI >= 0) {
            //  Add the cumulative value to the parent   
                sums[parentOfI] += sums[i];
            }
        }
        printArray("Sums", sums);
        
        int[] diff = new int[sums.length];
        for (int i=0; i<sums.length; i++) {
            // Cutting the branch
            diff[i] = sums[0] - sums[i];
        }
        printArray("Diff", diff);
        
        for (int i=0; i<sums.length; i++) {
            // Seeking for most balanced partition value
            if (Math.abs(sums[i] - diff[i]) < min) {
                min = Math.abs(sums[i] - diff[i]);   
            }
        }
        return min;
    }
    
    public static void printArray (String title, int[] arr) 
    {
        System.out.print(title + ": [");
        for (int i=0; i<arr.length-1; i++) 
            System.out.print(arr[i] + ", ");
        System.out.println(arr[arr.length-1]+"]");
    }
    
}