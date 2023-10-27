package exercise;

import edu.princeton.cs.algs4.StdOut;

public class PermutationArray {
    // get the vaue at each index 
    // set the aue to the index of the new array
    // use the new index to get the vaue of eachposition from the origina array

   
    
    public int[] Permutata(int[] nums) {
       int[] ans = new int[nums.length];
       int N = nums.length;
        for (int i = 0; i < N; i++) {
            ans[i] = nums[nums[i]]; 
        }
        StdOut.println("New Array Form:" + ans);
        return ans;
    }
    
}
