package exercise;

public class BitonicArray {
    
    


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
