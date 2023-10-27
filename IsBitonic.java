package exercise;

public class IsBitonic {

    public static boolean isBitonic(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right + left) /2 ;

            if (nums[mid] == target) return true;

            // check to see if were on the ascending part 
            if ( mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                // now check whether to move (left or right 
                if ( nums[mid] < target) {
                    right = mid - 1; 
                } else {
                    left = mid + 1;
                }
            } else {
                // now check the descending side
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;

    }
}