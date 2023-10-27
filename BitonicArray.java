package exercise;

public class BitonicArray {
    
    public static boolean bitonicArray(int[] nums, int traget) {

        int peakIndex = findPeak(nums);

        if (nums[peakIndex] == traget) return true;

        // using binary search to find the target in the ascending order
        int left = 0;
        int right = peakIndex - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == traget ) {
                return true;
            } else if (nums[mid] < traget) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        // binary serach on the descidng side 
        left = peakIndex;
        right = nums.length - 1; 

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == traget ) {
                return true;
            } else if (nums[mid] < traget) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        } 

        return false;
        
        
    }


    public static int findPeak(int[] num) {
        int right = num.length - 1;
        int left = 0;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (num[mid] < num[mid + 1]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }

        return left;
    }
}
