package exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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
    // resize the underying arrrays

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i <= n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last = n;
    }

    public void enqueue (Item item) {
        // double the size of the array
        if (n == q.length) resize(2*q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        n++;
    }
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null; 
        n--;
        first++;
        if (first == q.length) first = 0;
        // shtrink the size of the queueu

        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(first + i) % q.length];
            i++;
            return item;
        }
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
             
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}