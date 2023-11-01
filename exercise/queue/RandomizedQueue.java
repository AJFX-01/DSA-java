package exercise.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;
    private Random random; 

    // construct an empty randomized queue
    public RandomizedQueue() {

        items = (Item[]) new Object[2];
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

        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()) {
            throw new IllegalAccessException("the queue is empty");
        }

        int RandomIndex =  random.nextInt(size);
        Item item = items[RandomIndex];
        items[RandomIndex] = items[size - 1];
        size--;

        if(size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        } 

        return item;
    }



    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new IllegalAccessException("Exception error");
        }

        int RandomIndex = random.nextInt(size);
        return items[RandomIndex];

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {

    }

    private class RandomizedQueueIterrator implements Iterator<Item> {

        private int currentIndex;
        private final int[] RandomIndexes;
        
        public RandomizedQueueIterator() {
            currentIndex = 0;
            RandomIndexes = new int[size];
            for (int i = 0; i < size; i++ ) {
                RandomIndexes[i] = i;
            }

            // shuffe arofound the indexes

            for (int i = size - 1; i > 0; i--) {
                int j = random.nextInt( i + 1);
                int temp = RandomIndexes[i];
                
                RandomIndexes[i] = RandomIndexes[j];
                RandomIndexes[j] = temp; 
            }
        } 

        public boolean hasNext() {
            return currentIndex < size;
        }

        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No more eeemnt in st")
            }

            return items[RandomIndexes[currentIndex++]];
        } 

        public void remove() {
            throw new UnsupportedOperationException("Remova not aowed")  
        }
    }


    private void resize(int capacity) {
        Item[] copyItems = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            items[i] = copyItems[i];
        }
        items = copyItems;
    }

    // unit testing (required)
    public static void main(String[] args)

}
