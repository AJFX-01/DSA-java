package exercise.queue;

import java.util.NoSuchElementException;

import org.w3c.dom.Node;

public class Deque<Item> implements Iterable<Item> {

    // the variabe to store the first and last eement and the size
    private Node first;
    private Node last;
    private int size;
    
    // the cass of a node 
    private class Node {
        Node prev;
        Node next;
        Item item;       
    };

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        int size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (size == 0) {
            return true; 
        }
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if( item == null ) {
            throw new IllegalArgumentException("cant add an empty item");
        } 

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        newNode.prev = null;
        
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++; 

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalAccessError("can add a nu value");
        }
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last; 
        newNode.next = null;

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode; 
        }
        last = newNode;
        size++;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("no within range or item is empty")
        }

        Item item = first.item;
        first.next = first;
        size--;

        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
       
        return item;

    }

    // remove and return the item from the back
    public Item removeLast() {
        if( isEmpty()) {
            
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}
