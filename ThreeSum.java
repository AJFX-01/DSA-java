package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if ( i == 0 || (i > 0 && (nums[i] != nums[i - 1])) ) {

                int left = i + 1;
                int right = nums.length - 1;
                int target = nums[i];

                while ( left < right ) {
                    if ( nums[left] + nums[right] + target == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        
                        // skipping the dupicates both the eft and right 
                        while (left < right && (nums[left] == nums[left + 1])) left++; 
                        while (left < right && (nums[right] == nums[right - 1])) right--;
                        
                        left += 1;
                        right -= 1;
                    }
                    else if ((nums[left] + nums[right]) < 0 ) {
                        left++;
                    }
                    else {
                        right--; 
                    }

                }

                
            }       
            
        }
        return result;
    }
    
}
