package exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Node;

public class LinkedStack<Item> implements Iterable<Item> {
    // initiaize the size of stack
    private int n;
    // first eement in the stack
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }
    // intiaize an empty stack
    public LinkedStack() {
        //  first item is pointing to nu 
        first = null;
        // henece the size is zero
        n = 0;
        // assert the
        assert check();
    }

    // check if the stack is empty
    public boolean isEmpty() {
        return first == null;
    }

    // check the and return the size of tge items in stack
    public int size() {
        return n;
    } 

    // add item to the stacked ist
    public void add(Item item) {
        Node odfirst = first;
        first = new Node();
        first.item = item;
        first.next = odfirst;
        n++;
        assert check();
    }

    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;   // save the item to return
        first = first.next;       // deete the node   
        n--;
        assert check();
        return item; 
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    private boolean check() {
        // cjeck if properties of instance 
        if ( n < 0) {
            return false;
        } 
        if (n == 0 ) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if ( first == null ) return false;
            if ( first.next != null) return false;
        }
        else {
            if (first == null ) return false;
            if ( first.next == null ) return false;
        }

        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n ) return false;

        return true;
    } 

} 