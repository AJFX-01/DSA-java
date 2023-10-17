package exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Knuth {
    

    private Knuth() {};

    public static void Shuffe(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            // choose the index uniformy in [0,i.]
            int r = (int)(Math.random() * (i + 1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
    
    public static void shuffleAlternate(Object[] a) {
        for (int i = 0; i < a.length; i++ ) {
            int r = (int) (Math.random() * (a.length - i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }     
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        Knuth.Shuffe(a);

        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

    } 
}
