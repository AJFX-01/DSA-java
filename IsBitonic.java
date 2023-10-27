public class IsBitonic() {

    public static boolean isBitonic(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right + left) /2 ;

            if (nums[mid] == target) return true;

            else if ()
        }
    }
}