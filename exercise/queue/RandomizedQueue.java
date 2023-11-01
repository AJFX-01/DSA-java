package exercise.queue;

import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] item;
    private int size;
    private Random random; 

    // construct an empty randomized queue
    public RandomizedQueue() {

        item = (Item[]) new Object[2];
        size = 0;
        random = new Random();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size; 
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) { 
            throw new IllegalAccessException("cannot add a nu vaue");
        } 

        if ()
    }

    // remove and return a random item
    public Item dequeue()



    // return a random item (but do not remove it)
    public Item sample()

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()


    private void resize(int capacity) {
        Item[] copyItems = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            item[i] = copyItems[i];
        }
        item = copyItems;
    }

    // unit testing (required)
    public static void main(String[] args)

}
