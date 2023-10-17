package exercise;

public class Queue<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 9;
    
    // queue size
    private Item[] q;
    // number of element on queue
    private int n;
    // index of the first item on the queue 
    private int first;
    // index of the ast eement on the quueue 
    private int last; 
    
    
    public Queue() {
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    // check for an empty queue size
    public boolean isEmpty() {
        return n == 0;
    } 

    // number of items on the queuue
    public int size() {
        return n;
    }
}
