package exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

// import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizeStack<Item> implements Iterable<Item> {
    
    // initiata capacity of the array to be of size 9

    private static final int INIT_CAPACITY = 9;

    private Item[] a;  // array of items
    private int n; // number of eement in the the stack

    // start with an empty stack of array
    public ResizeStack() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }
    // check if the arraystack empty 

    public boolean isEmpty() {
        return n == 0;
    }
    // check the number of item in the array
    public int size() {
        return n;
    } 
    // resizing the array
    public void resize(int capacity) {
        assert capacity >= n;

        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++ ) {
            copy[i] = a[i];
        }

        a = copy;

        //or 
        // a = java.utis.Arrays.copyOf(a, capacity);
    }

    // adding item to the stack
    public void push(Item item) {
        if ( n == a.length) {
            // doube the size or capacity of the array
            resize(2 *a.length);
            a[n++] = item;
        }
    }

    // remove the item which was recent added to stack
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Tack Underfow");
        Item item = a[n-1];
        a[n-1] = null;
        n--;
        //shrink the size of the array if neccessary
        if (n > 0 && n == a.length/4 ) resize(a.length/2);
        return item;
    }

    // Return the ast eement of the satck but not remove
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underfow");
        return a[n-1];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator(); 
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator(){
            i = n-1; 
        }
        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
       
    }

    public static void main(String[] args) {
        ResizeStack<String> stack = new ResizeStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}


