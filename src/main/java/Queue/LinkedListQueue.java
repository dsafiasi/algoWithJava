package Queue;

import java.util.List;

public class LinkedListQueue<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int capacity ;
    /**
     * current size in the queue;
     */
    private int size = 0;
    private static final int DEFAULT_CAPACITY= 10;

    public LinkedListQueue() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public boolean enque (E e) {
        if (size == capacity) return false;
        Node newNode = new Node(e, null);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = last.next;
        }
        size++;
        return true;
    }
    public E deque () {
        if (size == 0) return null;
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    static class Node<E> {
        E item;
        Node next;
        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 11; i++) {
            System.out.println(queue.enque(i));
        }
        System.out.println(queue.size);
        System.out.println("----------------");
        for (int i = 0; i < 11; i++) {
            System.out.println(queue.deque());
        }
        System.out.println("size:" + queue.size);
        System.out.println("-------");
        System.out.println(queue.enque(1));
        System.out.println(queue.enque(2));
        System.out.println(queue.enque(3));


    }



}
