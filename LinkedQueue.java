import java.util.NoSuchElementException;

import org.w3c.dom.Node;

public class LinkedQueue<Item> implements Iterable<item> {

    private int n;
    private Node first;
    private Node last;
    
    private class Node {
        private Item item;
        private Node next;
    }

    // an empty queue intit
    public LinkedQueue() {
        first = null;
        last = null;
        n = 0;
        assert check ();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size () {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue Underfow");
        return first.item;
    }
    
    public void enqueue(Item item) {
        Node odlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if( isEmpty()) first = last;
        else odlast.next = last;
        n++;
        assert check(); 
    }

    public void dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue Underflow");
        Item item = first.item;
        first = first.next;
        n--;
        
        if (isEmpty()) last = null;
        assert check();
        return item; 
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

   private boolean check() {
    if (n < 0) {
       return false;
    }

    else if ( n == 0 ) {
        if ( first != null ) return false;
        if (last != null ) return false;
    }

    else if (n ==1) {
        if (first == null || last == null ) return false;
        if ( first != last ) return false;
        if (first.next == null ) return false;
        if (last.next != null ) return false;
    }

    else {
        if (first == null || last == null ) return false;
        if ( first != last ) return false;
        if (first.next == null ) return false;
        if (last.next != null ) return false;


        /// check intena consistency
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next ) {
            numberOfNodes++;
        }
        if (numberOfNodes != n ) return false;
        // check for ast
    }
   }

} 