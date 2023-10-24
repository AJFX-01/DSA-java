package exercise.percolation;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    
    private int gridsize;
    private boolean[] openSites;
    private int[] parent;
    private int[] size;
    private int virtualTop;
    private int virtualBottom; 

    public Percolation(int n) {
        if (n < 0) throw new IllegalArgumentException(" Grid size must be greater than n");

        gridsize = n;
        
        int totalSites = n * n;
        parent = new int[totalSites];
        size = new int[totalSites];
        openSites = new boolean[totalSites];
        virtualBottom = totalSites - 1;
        virtualTop = totalSites;
        // initiaizw the parent and size arrrays
        for (int i = 0; i < totalSites; i++) {
            parent[i] = i;
            size[i] = i;
        } 
    }

    
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = getIndex(row, col);
        openSites[index] = true;
        
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = getIndex(row, col);
        return openSites[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        
        int index = getIndex(row, col);
        return isOpen(row, col) && isConnected(index, virtualTop);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 0; i < gridsize * gridsize; i++) {
            if (openSites[i]) {
                count++;
            }
            
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return isConnected(virtualTop, virtualBottom);
    }


    private boolean isvalid(int row, int col) {
        return row >= 1 && row <= gridsize && col >= 1 && col <= gridsize; 
    } 

    private int getIndex(int row, int col) {
        if (!isvalid(row, col)) throw new IllegalArgumentException("Invalid row or column");

        return (row - 1) * gridsize + (col - 1);
    }

    private void ConnectedNeighbor(int row, int col) {
        int[][] neighbors = { {-1, 0}, {1, 0}, {0, -1} , { 0, 1}};
        
        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];

            if (isvalid(newRow, newCol) && isOpen(newRow, newCol)) {
                int index = getIndex(row, col);
                int neighborIndex = getIndex(newRow, newCol);
                union(index, neighborIndex);
            }
        }
    }

    private void union(int p, int q)  {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] =rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    private int find(int p) {
        while ( p != parent[p] ){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
