package Queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class IArrayBlockingQueue<E> extends ArrayQueue<E> {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    /** Condition for waiting puts */
    private final Condition notFull = lock.newCondition();

    /** Condition for waiting takes */
    private final Condition notEmpty = lock.newCondition();

    public IArrayBlockingQueue() {
        super();
    }

    public IArrayBlockingQueue(int capacity) {
        super(capacity);
    }

    public void enqueue (E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == super.getCapacity()) {
                notFull.await();
            }
            super.enque(e);
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    public E dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            E e = super.deque();
            count--;
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IArrayBlockingQueue<Integer> queue = new IArrayBlockingQueue<>(2);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
//


}
