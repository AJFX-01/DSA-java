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

    
}