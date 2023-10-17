package exercise;

import java.util.Arrays;

public class StaticSet {
    
    private int[] a;

    public  StaticSet(int[] keys) {
        a = new int[keys.length];

        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }

        Arrays.sort(a);

        for(int i = 1; i < a.length; i++ ) {
            if (a[i] == a[i-1]) {
                throw new IllegalArgumentException("Argument arrays contains dupicates keys");
            }
        }
    }

    public boolean contains(int key) {
        return BinarySearch(key) != -1 ;
    } 

    public int BinarySearch(int key) {
        int start = 0;
        int end = a.length - 1;

        while( start <= end) {
          int midpoint = start + (end - start) / 2;
          if (key < a[midpoint]) {
                start = midpoint - 1;
            }
            else if (key > a[midpoint]) {
                end = midpoint + 1;
            }
            else {
                return midpoint;
            }  
        }
        return -1;
    }
}
