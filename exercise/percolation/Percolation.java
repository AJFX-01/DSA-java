package exercise.percolation;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    private boolean[][] grid;
    private int gridsize;

    public Percolation(int n) {
        if (n < 0) throw new IllegalArgumentException(" Grid size must be greater than n");

        gridsize = n;
        grid = new boolean[n][n]; 
    }

    public boolean isvalid(int row, int col) {
        return row >= 1 && row <= gridsize && col >= 1 && col <= gridsize; 
    } 
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isvalid(row, col)) {
            throw new IllegalArgumentException("invaid row or column");
        }
        grid[row - 1][col - 1] = true;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        open(row, col);
        return grid[row  -1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites()

    // does the system percolate?
    public boolean percolates()

    // test client (optional)
    public static void main(String[] args) 
}
