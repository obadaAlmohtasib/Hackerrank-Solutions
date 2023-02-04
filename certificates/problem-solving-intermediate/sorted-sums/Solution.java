import java.util.*;

public class Solution {

    //
    // Complete the 'sortedSum' function below.
    //
    // The function is expected to return an INTEGER.
    // The function accepts INTEGER_ARRAY a as parameter.
    //
    public static int sortedSum(List<Integer> a) 
    {
        // NOTE: 
        // The solution does not take duplicate values in consideration. 
        // So it works properly with unique values set.
        List<Integer> sortedList = new ArrayList<>(a);
        Collections.sort(sortedList);
        
        int ans = 0;
        int[][] seq = new int[a.size()][a.size()];
        
        for (Integer el: sortedList) { 
            int INDEX = a.indexOf(el);
            for (int i=INDEX; i<a.size(); i++) {
                seq[i][1]++; // Multiplier
                seq[i][0] += seq[i][1] * el; // Sum
            }
        }
        
        for (int i=0; i<seq.length; i++) {
            System.out.println("Seq["+(i+1)+"]: "+seq[i][0]);
            ans += seq[i][0]; // Sum all sequences
        }
        
        return ans;
    }
    
    public static void main(String args[]) {
        // Input
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(4, 3, 2, 1)); 
        
        // Solution
        int result = sortedSum(arr);
        System.out.println("Result: " + result);
    }
    
    // Test Cases: 
    // [4, 3, 2, 1] => 65
    // [9, 5, 8] => 80
    // [5, 9] => 28
    // [747402, 380408, 605449, 846906, 385224, 31431, 677517, 770001, 389085, 40373, 487560, 886252, 596334, 59083] => 364271696
    // [552565, 251358, 612259, 542802, 12194, 345248, 290765, 232501, 391793, 107191, 726097] => 132805734
    // [989605, 554335, 938146, 420327, 573599, 674780, 226418, 80001, 589043, 194195] => 160569914
    // [542169, 805692, 66757, 479481, 585792, 20027, 517182, 312501, 497188, 817738, 709039, 983570, 397053, 176499] => 344134692
    // [726610, 5429, 998092, 203911, 48773, 897342, 163057, 930001, 83522, 945114] => 145945368
    
    
}
