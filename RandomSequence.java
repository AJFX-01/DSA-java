package exercise;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSequence {
    // instantiate the cass 
    private RandomSequence() {};

    public static void main(String[] args) {

        // taes in the command ine arguement 
        int n = Integer.parseInt(args[0]);
        // 
        if (args.length == 1) {
            // generate and print number betweeen 1 nad 0
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniformDouble(0.0, 1.0);
                StdOut.println(x);
            }
        }
        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);   

            for (int i = 0 ; i < n; i++ ) {
                double x = StdRandom.uniformDouble(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        } 
        else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    } 
}
