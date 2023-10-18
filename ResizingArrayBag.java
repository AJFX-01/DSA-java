package exercise;

public class ResizingArrayBag<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 8;

    private Item[] a;
    private int n;

    public ResizingArrayBag() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
         copy[i] = a[i];
        a = copy;
    }

    public void add(Item item) {
        if (n == a.length )
        resize(2* a.length); 
        a[n++] = item;
    }
}
