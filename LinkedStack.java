package exercise;

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
    public 

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