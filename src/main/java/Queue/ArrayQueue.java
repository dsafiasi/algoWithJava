package Queue;

public class ArrayQueue<E> {
    private E[] array ;
    private int capacity;
    /**
     * enqueue position
     */
    private int first;

    /**
     * dequeue position
     */
    private int last;
    private final int DEFAULT_CAPACITY = 10;

    public int getCapacity() {
        return capacity;
    }

    public ArrayQueue() {
        this.capacity = DEFAULT_CAPACITY;
        array = (E[]) new Object[capacity];
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    public boolean enque(E e) throws InterruptedException {
        if (last == capacity) {
            if (first != 0) {
                update();
            } else return false;
        }
        array[last++] = e;
        return true;
    }

    public E deque() {
        if (first == last) return null;
        return array[first++];
    }
    private void update() {
        int j = 0;
        for (int i = first; i < last; i++) {
            array[j++] = array[i];
        }
        first = 0;
        last = j;
    }



}
