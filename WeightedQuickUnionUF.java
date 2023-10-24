import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;


    //Initializes an empty union-find data structure with
    public WeightedQuickUnionUF(int n) {
        count= n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        } 
    } 

    public int count() {
        return count;
    }

    // vaidating the p
    public void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index" + p + "is not between 0 and" + (n-1));
        }
    }

    public int find(int p) {
        validate(p);
        while ( p != parent[p]) {
           p = parent[p]; 
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if (rootP == rootQ);

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ]; 
        }

        count--;
    } 

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(uf.count() + "components");
        }
    }
}

/////
public class Percolation {
    private int[] parent;
    private int[] size;
    private boolean[] openSites;
    private int gridSize;
    private int virtualTop;
    private int virtualBottom;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid size must be greater than 0");
        }
        gridSize = n;
        int totalSites = n * n;
        parent = new int[totalSites];
        size = new int[totalSites];
        openSites = new boolean[totalSites];
        virtualTop = totalSites;
        virtualBottom = totalSites + 1;
        
        // Initialize parent and size arrays
        for (int i = 0; i < totalSites; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void open(int row, int col) {
        int index = getIndex(row, col);
        openSites[index] = true;

        // Connect to neighboring open sites
        connectToNeighbors(row, col);
    }

    public boolean isOpen(int row, int col) {
        int index = getIndex(row, col);
        return openSites[index];
    }

    public boolean isFull(int row, int col) {
        int index = getIndex(row, col);
        return isOpen(row, col) && isConnected(index, virtualTop);
    }

    public boolean percolates() {
        return isConnected(virtualTop, virtualBottom);
    }

    private int getIndex(int row, int col) {
        if (!isValid(row, col)) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        return (row - 1) * gridSize + (col - 1);
    }

    private boolean isValid(int row, int col) {
        return row >= 1 && row <= gridSize && col >= 1 && col <= gridSize;
    }

    private void connectToNeighbors(int row, int col) {
        int[][] neighbors = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];

            if (isValid(newRow, newCol) && isOpen(newRow, newCol)) {
                int index = getIndex(row, col);
                int neighborIndex = getIndex(newRow, newCol);
                union(index, neighborIndex);
            }
        }
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // Path compression
            p = parent[p];
        }
        return p;
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int n = 5; // Change this to your desired grid size.
        Percolation percolation = new Percolation(n);

        // You can now open sites, check if they are open, check if they are full, and check if the system percolates.
        // The implementation of these methods is provided above using the Union-Find approach.
    }
}
