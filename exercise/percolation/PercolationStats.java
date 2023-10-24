package exercise.percolation;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int totalTrials; 
     // perform independent trials on an n-by-n grid
     public PercolationStats(int n, int trials){
        // check if trails and gird size n
        if ( trials <= 0 || n < 0) throw new IllegalAccessException("invalid range of trais time or gride size");
        
        // set tota tria times
        totalTrials = trials;
        // the threshod set to the trai times ramge
        thresholds = new double[trials];

        // loop through the trias during the number of trails times
        for (int t = 0; t < trials; t++) {
            // initaiize the percolation instance of the class
            Percolation percolation = new Percolation(n);
            // set the opensite count to 0 
            int openSites = 0;
            // iteracte through the process to check if the system percolates or not  
            while (!percolation.percolates()) {
                // since it does not percolates, generate two round voice 
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                // check if the site of the generated nymber are openedor not
                if (!percolation.isOpen(row, col)) {
                    // open it 
                    percolation.open(row, col);
                    //addd it to the number of opensites 
                    openSites++;
                }
            }
            // set the threshold to the number of opensites divided by the gridesize
            double threshold = (double) openSites / ( n * n );
            thresholds[t] = threshold;
        }
     }

     // sample mean of percolation threshold
     public double mean() {
        return StdStats.mean(thresholds);
     }
 
     // sample standard deviation of percolation threshold
     public double stddev() {
        return StdStats.stddev(thresholds);
     }
 
     // low endpoint of 95% confidence interval
     public double confidenceLo() {
        double mean = mean();
        double stddev = stddev();
        return mean - (1.96 * stddev / Math.sqrt(totalTrials));
     }
 
     // high endpoint of 95% confidence interval
     public double confidenceHi() {
        double mean = mean();
        double stddev = stddev();
        return mean + (1.96 * stddev / Math.sqrt(totalTrials));
     }
 
    // test client (see below)
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int trials = StdIn.readInt();

        // instantiae the cass
    }
}
