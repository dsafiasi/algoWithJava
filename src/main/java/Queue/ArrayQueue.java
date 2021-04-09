package Queue;

public class ArrayQueue<E> {
    private E[] array ;
    private int capacity;
    /**
     * enqueue position
     */
    private int tail;

    /**
     * dequeue position
     */
    private int head;
    private int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        this.capacity = DEFAULT_CAPACITY;
        array = (E[]) new Object[capacity];
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    public void enqueue(E e) {
        if (tail >= capacity) {
            if (head != 0) {
                update();
            } else return;
        }
        array[tail++] = e;
    }
    private void update() {
        int j = 0;
        for (int i = head; i < tail; i++) {
            array[j++] = array[i];
        }

        head = 0;
        tail = j;
    }

    public E dequeue() {
        if (head == tail) return null;
        return array[head++];
    }
    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.println(array[i]);
        }

    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();

        queue.printAll();

    }

}
