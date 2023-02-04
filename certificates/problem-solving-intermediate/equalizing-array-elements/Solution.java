import java.util.*;

public class Solution {
    //  Complete the 'minOperations' function below.
    
    //  The function is expected to return an INTEGER.
    //  The function accepts following parameters:
    //   1. INTEGER_ARRAY arr
    //   2. INTEGER threshold
    //   3. INTEGER d
    public static int minOperations(List<Integer> arr, int threshold, int d) {
        // To count the min min operations, we need a sorted array
        Collections.sort(arr);
        
        // Dict { , [ , ]}
        Map<Integer, Integer[]> dict = new HashMap<>();
        int minOps = Integer.MAX_VALUE;
        
        for (Integer i: arr) {            
            int steps = 0;            
            // Pre-check to avoid re-initialize for duplicate numbers
            if (dict.get(i) == null)
                dict.put(i, new Integer[] { 1, steps });
            else {
                dict.get(i)[0]++; // [i] Equal array elements | occurrences;
                dict.get(i)[1]+=steps; // minimum number of operations
            }
            
            while (true) {                
                if (dict.get(i)[0] == threshold)
                    minOps = Math.min(dict.get(i)[1], minOps);                
                if (i == 0)
                    break;                    
                i /= d; // using integer division
                steps++;                
                if (dict.get(i) == null)
                    dict.put(i, new Integer[] { 1, steps });
                else {
                    dict.get(i)[0]++; // [i] Equal array elements | occurrences;
                    dict.get(i)[1]+=steps; // minimum number of operations
                }
            }
        }        
        return minOps;
    }
    
    public static void main(String args[]) {
        // Input
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(64, 33, 8, 16, 0, 9)); 
        int threshold = 2;
        int division_parameter = 3; 
        
        // Solution
        int minOps = minOperations(arr, threshold, division_parameter);
        System.out.println("Min Ops: " + minOps);
    }
    
}










