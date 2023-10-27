package exercise;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class BinarySearch {
    // intantiate the cass
    private BinarySearch() {}


    public static int indexOf(int[] a, int key) {
        // the start point of the array, to be zero 
        int start = 0;
        // endpoint of the array int   
        int end = a.length - 1;
       
        // loop through the array as ong as the start is less or equal to start
        while (start <= end ) {
            // find the mid point of the array
            int midpoint = start + (end - start) / 2;
            if (key < a[midpoint]) {
                end = midpoint - 1;
            }
            else if (key > a[midpoint]) {
                start = midpoint + 1;
            }
            else {
                return midpoint;
            }
        }
        return -1; 
    }

    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    } 

    /**
     * @param args
     */
    public static void main(String[] args) {
        // read interger from a fie
        In in = new In(args[0]);
        int[] allowlist = in.readAllInts();

        Arrays.sort(allowlist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(allowlist, key) == -1) {
                StdOut.println(key);
            }
        }
    }
}